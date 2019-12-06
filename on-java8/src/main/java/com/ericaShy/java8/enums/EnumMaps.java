package com.ericaShy.java8.enums;

import java.util.EnumMap;
import java.util.Map;

import static com.ericaShy.java8.enums.AlarmPoints.*;

interface Command { void action(); }

public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        System.out.println(em);

        em.put(KITCHEN, () -> System.out.println("Kitchen fire!"));
        em.put(BATHROOM, () -> System.out.println("Bathroom alert!"));
        System.out.println(em);

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }

        try {
            em.get(UTILITY).action();
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
    }

}
