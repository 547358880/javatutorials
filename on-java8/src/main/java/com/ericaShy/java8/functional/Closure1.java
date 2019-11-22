package com.ericaShy.java8.functional;

import java.util.function.IntSupplier;

/**
 * javascript定义(https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Closures):
 * 函数与其状态即词法环境的引用共同构成闭包(closure), 也就是说闭包可以让你从内部函数访问到外部函数作用域
 *
 * [学习Javascript闭包（Closure）](https://www.ruanyifeng.com/blog/2009/08/learning_javascript_closures.html)
 * 闭包（支持函数作用域之外的变量）
 */
public class Closure1 {

    int i;

    IntSupplier makeFunc(int x) {
        return () -> x + i++;
    }

}
