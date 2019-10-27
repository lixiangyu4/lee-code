package com.lixiangyu.lee.springboot.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.ExecutionException;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-27 15:50
 **/
public class AsyncTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AyncConfig.class);
        TestService testService = context.getBean(TestService.class);

        /**
         * 调用无返回值的Aync方法, 异常无法传递到调用线程里，
         * 1、所以需要实现 AsyncUncaughtExceptionHandler 接口，来定义抛出异常时的处理方式
         * 2、或者通过config文件中实现 AsyncConfigurer 接口， 来定义抛出异常的处理方式
         * @see AsyncUncaughtExceptionHandler
         * @see AsyncConfigurer
         */
        System.out.println("===test_no_result======");
        testService.test_no_result();
        /**
         * 调用返回值为Future的Aync方法，异常直接通过Future.get() 获取
         */
        System.out.println("===test_with_result======");
        testService.test_with_result();
    }

}
