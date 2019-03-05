package com.lixiangyu.lee.springboot.im;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 22:32
 **/
@Configuration
@Import({Color.class,Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig3 {

    /**
     * 给容器中注册组件：
     * 1、包扫描+组件标注注解(@Controller/@Service/@Repository/@Component)
     * 2、@Bean 导入第三方包组件
     * 3、@Import注解,快速给容器中导入一个组件
     *      1) @Import(要导入的组件)放在类上：容器中就会自动注册这个类，id是全限定名
     *      2) ImportSelector：返回需要导入组件的全限定名
     *      3) ImportBeanDefinitionRegistrar : 手动注册到Bean容器中
     * 4、使用spring提供的FactoryBean(工厂Bean)
     *      1)默认获取到的是工厂Bean调用getObject创建的对象
     *      2)要获取工厂Bean本身，需要在 id前加&后获取
     */


}
