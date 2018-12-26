package com.lixiangyu.lee.spring.config;

import com.lixiangyu.lee.spring.bean.Color;
import com.lixiangyu.lee.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-24 15:32
 **/
@ComponentScan("com.lixiangyu.lee.spring.*")
@Configuration
@Import(Color.class)
public class BeanConfiguration {

    @Bean(initMethod = "init_mothod", destroyMethod = "destory_mothod")
    public Person person() {
        return new Person(1L,"aaa");
    }

//    @Conditional({WindowsCondition.class})
//    @Bean("bill")
//    public Person person01() {
//        return new Person(1L, "Bill");
//    }
//    @Conditional({LinuxCondition.class})
//    @Bean("linus")
//    public Person person02 () {
//        return new Person(2L, "linus");
//
//    }
}
