package com.ericaShy.java8.files;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadLineStream {

    public static void main(String[] args) throws Exception {
        Files.lines(Paths.get("src/main/java/com/ericaShy/java8/files/PathInfo.java"))
            .skip(11)
            .findFirst()
            .ifPresent(System.out::println);
    }

}
