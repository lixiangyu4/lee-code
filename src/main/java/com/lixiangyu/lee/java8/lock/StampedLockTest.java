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
     *  排他锁-写锁
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
        //尝试获取乐观读锁
        long stamp = sl.tryOptimisticRead();
        //将全部变量复制到方法体栈内
        double currentX = x, currentY = y;
        //检查在上面获取了读锁戳记后，锁没有被其他写线程排他性抢占
        if (!sl.validate(stamp)) {
            //如果被抢占则获取一个共享读锁（悲观获取）
            stamp = sl.readLock();
            try {
                //将变量保存在本地栈中
                currentX = x;
                currentY = y;
            } finally {
                //释放共享读锁
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    /**
     * 使用悲观锁获取读锁，并尝试转换为写锁
     * @param newX
     * @param newY
     */
    void moveIfAtOrigin(double newX, double newY) {
        // 这里可以使用乐观锁替换
        long stamp = sl.readLock();
        try {
            //如果当前在原点则移动
            while (x == 0.0 && y == 0.0) {
                //尝试将读锁转为写锁
                long ws = sl.tryConvertToWriteLock(stamp);
                //成功转换为写锁，则更新戳记，并设置坐标值，然后退出循环
                if (ws != 0L) {
                    //如果成功 替换票据
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    //读锁升级写锁失败则释放读锁，显示获取独占写锁，然后循环重试
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            //释放锁
            sl.unlock(stamp);
        }
    }

}
