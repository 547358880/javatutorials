package com.ericaShy.actionjava8.chapter11;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

public class Unit {

    private static final Random rand = new Random(0);
    private static final DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US.US));

    public static void delay() {
        int delay = 500 + rand.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double format(double number) {
        synchronized (formatter) {
            return new Double(formatter.format(number));
        }
    }
}
