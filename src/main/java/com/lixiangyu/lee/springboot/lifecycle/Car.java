package com.lixiangyu.lee.springboot.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 23:23
 **/
public class Car implements InitializingBean, DisposableBean {

   public void init_method() {
       System.out.println("init_method=====");
   }


    public void destroy_method() {
        System.out.println("destroy_method=====");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet====");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy====");
    }
}
