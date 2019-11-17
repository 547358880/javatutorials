package com.ericaShy.java8.polymorphism;

/**
 * 只用普通的方法调用是多态的，如果直接访问一个属性，该访问会在编译时解析
 */
class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

public class FieldAccess {

    public static void main(String[] args) {
        Super sup = new Sub();


        //sup.field=0, sup.getField(() = 1
        System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();

        // sup.field = 1, sup.getField() = 1, sub.getSuperField() = 0
        System.out.println("sup.field = " + sub.field +
                ", sup.getField() = " + sub.getField()
                + ", sub.getSuperField() = " + sub.getSuperField());
    }
}
