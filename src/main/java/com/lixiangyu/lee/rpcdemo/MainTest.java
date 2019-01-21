package com.lixiangyu.lee.rpcdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-20 16:25
 **/
@ComponentScan("com.lixiangyu.lee.rpcdemo")
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class MainTest implements ApplicationContextAware {

    @Test
    public void test1() {
        System.out.println("aaa");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RpcService.class);

        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
            System.out.println(entry.getKey());
            try {
                Method say = entry.getValue().getClass().getMethod("say", new Class[]{});
                Object invoke = say.invoke(entry.getValue(), null);
                System.out.println(invoke);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
