package com.ericaShy.java8.annotations;

import com.ericaShy.java8.onjava.ProcessFiles;

public class DemoProcessFiles {

    public static void main(String[] args) {
        new ProcessFiles(file -> System.out.println(file), "java").start(args);
    }
}
