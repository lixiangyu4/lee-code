package com.lixiangyu.lee.java8.lock;

import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @program: leecode
 * @description: 基于zookeeper 实现分布式锁
 * @author: lixiangyu
 * @create: 2019-07-12 10:27
 **/
public class ZookeeperLockTest {

    private String zkQurom = "localhost:2181";

    private String lockNameSpace = "/mylock";

    private String nodeString = lockNameSpace + "/test1";

    private ZooKeeper zk;

    public ZookeeperLockTest() {
        try {
            zk = new ZooKeeper(zkQurom, 6000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("Receive event " + watchedEvent);
                    if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                        System.out.println("connection is established...");
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void ensureRootPath() throws InterruptedException {
        try {
            if (zk.exists(lockNameSpace, true) == null) {
                zk.create(lockNameSpace, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    private void watchNode(String nodeString, final Thread thread) throws InterruptedException {
        try {
            zk.exists(nodeString, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("==" + watchedEvent.toString());
                    if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                        System.out.println("Threre is a Thread released Lock==============");
                        thread.interrupt();
                    }
                    try {
                        zk.exists(nodeString, new Watcher() {
                            @Override
                            public void process(WatchedEvent watchedEvent) {
                                System.out.println("==" + watchedEvent.toString());
                                if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                                    System.out.println("Threre is a Thread released Lock==============");
                                    thread.interrupt();
                                }
                                try {
                                    zk.exists(nodeString, true);
                                } catch (KeeperException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        });
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取锁
     */
    public boolean lock() throws InterruptedException {
        String path = null;
        ensureRootPath();
        watchNode(nodeString, Thread.currentThread());
        while (true) {
            try {
                path = zk.create(nodeString, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            } catch (KeeperException e) {
                System.out.println(Thread.currentThread().getName() + "  getting Lock but can not get");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    System.out.println("thread is notify");
                }
            }
            if (!StringUtils.isBlank(path)) {
                System.out.println(Thread.currentThread().getName() + "  get Lock...");
                return true;
            }
        }
    }

    /**
     * 释放锁
     */
    public void unlock() {
        try {
            zk.delete(nodeString, -1);
            System.out.println("Thread.currentThread().getName() +  release Lock...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws InterruptedException {

//        ExecutorService service = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 4; i++) {
//            service.execute(() -> {
//                ZookeeperLockTest test = new ZookeeperLockTest();
//                try {
//                    test.lock();
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                test.unlock();
//            });
//        }
//        service.shutdown();

        ZookeeperLockTest test = new ZookeeperLockTest();
        test.lock();
//        test.unlock();
    }

}
