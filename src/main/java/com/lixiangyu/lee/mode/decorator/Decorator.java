package com.lixiangyu.lee.mode.decorator;

/**
 * @program: leecode
 * @description: 装饰模式--装饰(Decorator)角色：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。
 * @author: lixiangyu
 * @create: 2019-06-17 15:58
 **/
public class Decorator implements IComponent {

    private IComponent component;

    public Decorator(IComponent component) {
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        component.sampleOperation();
    }

}
