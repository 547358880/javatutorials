package com.ericaShy.java8.enums;

import com.ericaShy.java8.onjava.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

enum Explore { HERE, THERE }

public class Reflection {

    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("_____ Analyzing " + enumClass + "_____");
        System.out.println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }

        System.out.println("Base: " + enumClass.getSuperclass());

        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);

        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        System.out.println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));

        System.out.println("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);

        System.out.println("**********************");
        OSExecute.command("javap -cp target/classes com.ericaShy.java8.enums.Explore");
    }

}
