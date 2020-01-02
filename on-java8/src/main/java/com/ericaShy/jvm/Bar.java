package com.ericaShy.jvm;

/**
 * P112
 * 启动参数
 * -Xcomp 让虚拟机以编译模式执行代码
 * -XX:CompileCommand=dontinline,*Bar.sum 这个表示不要把 run 方法给内联了，这是解决内联问题。
 * -XX:CompileCommand=compileonly,*Bar.sum 这个表示只编译 run 方法，这样的话只会输出sum方法的ASM码。
 * -XX:+PrintAssembly
 */
public class Bar {
    int a = 1;
    static int b = 2;

    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }
}
