package com.lixiangyu.lee.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-26 21:02
 **/
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        if("Windows 10".equalsIgnoreCase(property)) {
            return true;
        }
        return false;
    }
}
