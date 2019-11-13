package com.ericaShy.java8.polymorphism.music;

public class Wind extends Instrument{
    @Override
    public void play(Note n) {
        System.out.println("wind.play() " + n);
    }

    static void haha() {
        System.out.println("Wind.haha()");
    }
}
