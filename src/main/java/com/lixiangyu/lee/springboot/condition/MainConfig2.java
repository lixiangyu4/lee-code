package com.lixiangyu.lee.springboot.condition;


import com.lixiangyu.lee.springboot.Person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 21:49
 **/
@Configuration

public class MainConfig2 {

    /**
     * @Conditional :按照一定的条件进行判断，满足条件后给容器中注册Bean
     * Springboot自动注入的原理(jdbc等注入的原理)
     * 放在方法上为满足条件注册Bean
     * 放在类上为满足条件才注册这个类中的所有Bean 类中组件统一设置
     *
     * 需求：如果系统是Windows，则实例化bill，
     *      如果系统是Linux ，则实例化linus
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates" , 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus ")
    public Person person02() {
        return new Person("linus", 48);

    }
}
