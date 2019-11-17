package com.ericaShy.java8.reuse;

class Homer {
    char doh(char c) {
        System.out.println("doh(c)");
        return 'd';
    }

    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse {}

class Bart extends Homer {
    void doh(Milhouse m) {
        System.out.println("doh(Milhouse)");
    }
}

public class Hide {

    /**
     * 输出
     * doh(float)
     * doh(c)
     * doh(float)
     * doh(Milhouse)
     */
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}
