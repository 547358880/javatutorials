package com.ericaShy.java8.interfaces.interfaceprocessor;

public interface Processor {

    default String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input);
}
