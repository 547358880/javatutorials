package com.ericaShy.java8.polymorphism.music;

// Inheritance & upcasting
public class Music {

    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);

        // 输出Instrument.haha(), 因为static修饰的方法不会被动态绑定
        i.haha();
    }

    /**
     * 输出:
     * wind.play() MIDDLE_C
     */
    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);

        System.out.println("========");
        Wind.haha();
    }
}
