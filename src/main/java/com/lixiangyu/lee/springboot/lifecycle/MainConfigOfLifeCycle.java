package com.lixiangyu.lee.springboot.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 23:17
 **/
@Configuration
public class MainConfigOfLifeCycle {

    /**
     * Bean的生命周期： 创建 --- 初始化  --- 销毁的过程
     * 容器管理bean的生命周期：
     * 我们可以自己定义初始化和销毁的方法：容器进行到当前的生命周期时，会调用我们自定义的初始化和销毁方法
     *
     * 1、指定初始化和销毁的方法
     *      通过@Bean指定init-method和destroy-method
     * 2、通过让Bean实现InitializingBean定义初始化逻辑 DisposableBean定义销毁方法
     * 3、使用JSR250注解 @PostConstruct 在Bean创建完成并且属性赋值完成后进行初始化
     *                 @PreDestroy  在容器销毁Bean之前通知我们进行清理工作
     * 4、BeanPostProcessor 在Bean初始化前后进行一些处理工作
     *
     */

    @Bean(initMethod = "init_method", destroyMethod = "destroy_method")
    public Car car() {
        return new Car();
    }



}
