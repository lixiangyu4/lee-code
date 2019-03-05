package com.lixiangyu.lee.springboot.im;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 22:45
 **/
public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param importingClassMetadata 当前标注@Import类的所有注解信息
     * @return
     */

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.lixiangyu.lee.springboot.im.Blue","com.lixiangyu.lee.springboot.im.Yellow"};
    }
}
