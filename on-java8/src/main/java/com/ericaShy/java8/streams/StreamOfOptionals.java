package com.ericaShy.java8.streams;

import java.util.Optional;

public class StreamOfOptionals {

    /**
     * 输出
     * Optional[Signal(dot)]
     * Optional.empty
     * Optional[Signal(dash)]
     * Optional[Signal(dash)]
     * Optional[Signal(dot)]
     * Optional.empty
     * Optional[Signal(dash)]
     * Optional[Signal(dot)]
     * Optional.empty
     * Optional[Signal(dash)]
     *  ---
     * Signal(dot)
     * Signal(dot)
     * Signal(dash)
     * Signal(dash)
     * Signal(dash)
     */
    public static void main(String[] args) {
        Signal.stream()
            .limit(10)
            .forEach(System.out::println);
        System.out.println(" ---");
        Signal.stream()
            .limit(10)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .forEach(System.out::println);
    }

}
