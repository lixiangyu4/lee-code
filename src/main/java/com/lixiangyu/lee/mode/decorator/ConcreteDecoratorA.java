package com.lixiangyu.lee.mode.decorator;

/**
 * @program: leecode
 * @description: 具体装饰对象
 * @author: lixiangyu
 * @create: 2019-06-17 17:13
 **/
public class ConcreteDecoratorA extends Decorator {


    public ConcreteDecoratorA(IComponent component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();
    }


}
