package com.ericaShy.blog.cnblogs.dolphin0520;

import com.ericaShy.java8.strings.Immutable;

public class ImmutableRGB {
    private int red;

    private int green;

    private int blue;

    private String name;

    private void check(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public ImmutableRGB(int red, int green, int blue, String name) {
        check(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }

    public ImmutableRGB set(int red, int green, int blue, String name) {
        return new ImmutableRGB(red, green, blue, name);
    }

    public int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }
}
