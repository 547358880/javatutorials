package com.ericaShy.validating;

import java.util.function.Consumer;

import static com.google.common.base.Preconditions.*;

public class GuavaPreConditions {

    static void test(Consumer<String> c, String s) {
        try {
            System.out.println(s);
            c.accept(s);
            System.out.println("Success");
        } catch (Exception e) {
            String type = e.getClass().getSimpleName();
            String msg = e.getMessage();
            System.out.println(type + (msg == null ? "" : ": " + msg));
        }
    }

    public static void main(String[] args) {
        test(s -> s = checkNotNull(s), "X");
        test(s -> s = checkNotNull(s), null);
        test(s-> s = checkNotNull(s, "s was null"), null);
        test(s -> s = checkNotNull(s, "s was null, %s %s", "arg2", "arg3"), null);
        test(s -> checkArgument(s == "Fozzie"), "Fozzie");
        test(s -> checkArgument(s == "Fozzie"), "X");
        test(s -> checkArgument(s == "Fozzie"), null);
        test(s -> checkArgument(s == "Fozzie", "Bear Left! %s Right", "Frog"), null);
        test(s -> checkState(s.length() > 6), "Mortimer");
        test(s -> checkState(s.length() > 6), "Mort");
        test(s -> checkState(s.length() > 6), null);
        test(s -> checkElementIndex(6, s.length()), "Robert");
        test(s -> checkElementIndex(6, s.length()), "Bob");
        test(s -> checkPositionIndex(6, s.length()), "Robert");
        test(s -> checkPositionIndex(6, s.length()), "Bob");
    }
}
