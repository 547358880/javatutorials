package com.ericaShy.basic.algorithms4;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;

public class StdOut
{
    private static final String CHARSET_NAME = "UTF-8";

    private static final Locale LOCALE = Locale.US;

    private static PrintWriter out;

    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    private StdOut() { }

    public static void println() {
        out.println();
    }

    public static void println(Object x) {
        out.println(x);
    }
}
