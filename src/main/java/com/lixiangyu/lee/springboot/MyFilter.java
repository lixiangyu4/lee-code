package com.lixiangyu.lee.springboot;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 21:25
 **/
public class MyFilter implements TypeFilter {

    /**
     * @param metadataReader 读取到的当前扫描类的信息 the metadata reader for the target class
     * @param metadataReaderFactory 可以获取到其他任何类的信息 a factory for obtaining metadata readers
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //当前类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //获取当天类的资源（类的路径）
        Resource resource = metadataReader.getResource();

        System.out.println("--->" + classMetadata.getClassName());

        return false;
    }
}
