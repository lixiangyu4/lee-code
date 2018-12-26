package com.lixiangyu.lee.spring.config;

import com.lixiangyu.lee.spring.aop.LogAspect;
import com.lixiangyu.lee.spring.aop.MathAdd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-27 22:07
 **/
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAop {

    @Bean
    public LogAspect logAspect()  {
        return new LogAspect();
    }

    @Bean
    public MathAdd mathAdd() {
        return new MathAdd();
    }

}
