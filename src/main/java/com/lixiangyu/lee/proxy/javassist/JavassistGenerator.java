package com.lixiangyu.lee.proxy.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.io.IOException;

/**
 * @program: leecode
 * @description:
 * Javassist是一个开源的分析、编辑和创建Java字节码的类库。
 * 是由东京工业大学的数学和计算机科学系的 Shigeru Chiba （千叶 滋）所创建的。
 * 它已加入了开放源代码JBoss 应用服务器项目,通过使用Javassist对字节码操作为JBoss实现动态AOP框架。
 * javassist是jboss的一个子项目，其主要的优点，在于简单，而且快速。
 * 直接使用java编码的形式，而不需要了解虚拟机指令，就能动态改变类的结构，或者动态生成类。
 * @author: lixiangyu
 * @create: 2019-03-21 14:55
 **/
public class JavassistGenerator {

    public static void main(String[] args) throws CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        //创建Programmer类
        CtClass cc= pool.makeClass("com.JavassistGenerator.Programmer");
        //定义code方法
        CtMethod method = CtNewMethod.make("public void code(){}", cc);
        //插入方法代码
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");
        cc.addMethod(method);
        //保存生成的字节码
        cc.writeFile("/Users/lixiangyu/phoenix/lee-code/com/sun/proxy");

    }


}
