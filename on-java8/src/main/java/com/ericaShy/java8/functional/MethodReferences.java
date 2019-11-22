package com.ericaShy.java8.functional;

/**
 * 方法的签名： 方法名和参数类型
 * 方法引用
 *
 *
 * 函数描述符
 * () -> void代表参数列表为空， 且返回void的函数
 *
 * System.out::println是一个方法引用，相当于x->System.out.println(x)
 */

interface Callable {  //[1]
    void call(String s);
}

class Describe {

    // show()的签名（参数类型和返回类型）符合Callable的call()的签名
    void show(String msg) {  //[2]
        System.out.println(msg);
    }
}

public class MethodReferences {

    static void hello(String name) {  //[3]
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        /*
            静态内部类的非静态方法
         */
        void help(String msg) {      //[4]
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {        // [5]
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show;       // [6] object::instanceMethod

        // call()
        c.call("call()");

        c = MethodReferences::hello; //[8]      Class::instanceMethod
        c.call("Bob");

        c = new Description("valuable")::help;  // [9]
        c.call("information");

        c = Helper::assist;  // [10]
        c.call("Help!");
    }
}
