package com.lixiangyu.lee.java8.redo.defaultinterface;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-04 20:10
 **/
public class DefaultInterfaceTest implements InterfaceA, InterfaceB {

    /**
     * 默认方法优先级
     * 1、类中的方法优先级最高。类或父类中声明的方法的优先级高于任何声明为默认方法的优先级
     * 2、如果无法依据第一条进行判断，那么子接口的优先级最高；函数签名相同时，优先选择拥有追剧提实现的默认方法的接口，即如果B继承了A，那么B就比A更加具体
     * 3、最后，如果还是无法判断，继承了多个接口的类必须通过显示覆盖和调用期望的方法
     */

    @Override
    public void a() {
        /**
         * 显示调用InterfaceB中的默认方法
         */
        InterfaceB.super.a();
    }


}
