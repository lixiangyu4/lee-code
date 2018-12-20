package com.lixiangyu.lee.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-27 22:08
 **/
@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.lixiangyu.lee.spring.aop.MathAdd.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "==logStart=="+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("com.lixiangyu.lee.spring.aop.LogAspect.pointCut()")
    public void logEnd() {
        System.out.println("logEnd");
    }

    @AfterReturning(value = "pointCut()", returning = "object")
    public void logReturn(Object object) {
        System.out.println("logReturn=" + object);
    }

    @AfterThrowing("pointCut() ")
    public void lodException() {
        System.out.println("lodException");
    }

}
