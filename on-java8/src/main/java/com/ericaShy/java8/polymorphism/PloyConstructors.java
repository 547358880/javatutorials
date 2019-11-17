package com.ericaShy.java8.polymorphism;

/**
 * 构造器内部多态方法的行为
 */
class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PloyConstructors {

    /**
     * 输出:
     * Glyph() before draw()
     * RoundGlyph.draw(), radius = 0 (派生类初始化未完成)
     * Glyph() after draw()
     * RoundGlyph.RoundGlyph(), radius = 5
     */
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
