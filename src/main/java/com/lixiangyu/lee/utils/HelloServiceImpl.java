package com.lixiangyu.lee.utils;


/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-04-10 14:35
 **/
public class HelloServiceImpl implements IHelloService {


    @Override
    public void sayHello(long timeMillis) {
        long time = System.currentTimeMillis() - timeMillis;

        if(time > 5000) {
            //超过5秒打印日志
        }

        try {
            //模拟业务员执行时间
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
