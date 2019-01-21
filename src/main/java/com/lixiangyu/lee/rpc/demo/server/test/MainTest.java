package com.lixiangyu.lee.rpc.demo.server.test;

import com.lixiangyu.lee.rpc.server.NettyServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-20 16:25
 **/
@ComponentScan("com.lixiangyu.lee.rpc")
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class MainTest {

    @Test
    public void test1() {

        NettyServer nettyServer = new NettyServer(10000);
        nettyServer.create();

    }


//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RpcService.class);
//
//        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
//            System.out.println(entry.getKey());
//            try {
//                Method say = entry.getValue().getClass().getMethod("say", new Class[]{});
//                Object invoke = say.invoke(entry.getValue(), null);
//                System.out.println(invoke);
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
}
