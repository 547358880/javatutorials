package com.ericaShy.java8.typeinfo;

// 检查类加载器的工作方式
class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

public class SweetShop {
    /**
     * 输出:
     * inside main
     * Loading Candy
     * After creating Candy
     * Loading Gum
     * After Class.forName("Gum")
     * Loading Cookie
     * After creating Cookie
     */
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("com.ericaShy.java8.typeinfo.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
