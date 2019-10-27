package com.lixiangyu.lee.java8.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @program: leecode
 * @description: stampedLock
 * @author: lixiangyu
 * @create: 2019-07-11 10:04
 **/
public class StampedLockTest {

    private double x, y;
    private final StampedLock sl = new StampedLock();

    /**
     *  写锁
     * @param deltaX
     * @param deltaY
     */
    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * 乐观读锁
     * @return
     */
    double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead();
        double currentX = x, currentY = y;
        //检查发出乐观读锁后同时是否有其他写锁发生？
        if (!sl.validate(stamp)) {
            //如果有，我们再次获得一个读悲观锁
            stamp = sl.readLock();
            try {
                //将变量保存在本地栈中
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    /**
     * 悲观读锁 -- 读锁升级成写锁
     * @param newX
     * @param newY
     */
    void moveIfAtOrigin(double newX, double newY) {
        // Could instead start with optimistic, not read mode
        long stamp = sl.readLock();
        try {
            //循环，检查当前状态是否符合
            while (x == 0.0 && y == 0.0) {
                //将读锁转为写锁
                long ws = sl.tryConvertToWriteLock(stamp);
                //成功转换为写锁
                if (ws != 0L) {
                    //如果成功 替换票据
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    //显示释放读锁
                    sl.unlockRead(stamp);
                    //显示直接进行写锁,然后通过循环再试
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }

}
