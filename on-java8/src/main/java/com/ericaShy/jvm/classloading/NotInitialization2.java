package com.ericaShy.jvm.classloading;

/**
 * 常量在编译阶段会存入调用类的常量池中,本质上没有直接用到定义常量的类,不会触发定义常量的类的初始化
 */
public class NotInitialization2 {
    /**
     * 在编译阶段通过常量传播优化，已经将常量的值"hello world"存储到了NotInitialization2类的常量池中
     * 输出
     * hello world
     */
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORD);
    }
}
