package com.lixiangyu.lee.spring.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: leecode
 * @description: 自定义逻辑，返回需要导入的组件
 * @author: lixiangyu
 * @create: 2019-02-08 22:11
 **/
public class ColorImportSelector implements ImportSelector {
    /**
     * AnnotationMetadata 当前标注@Import注解的类的所有注解信息
     * @param importingClassMetadata
     * @return 返回值是注册到容器中类的全限定名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //方法不要返回null值
        return new String[0];
    }
}
