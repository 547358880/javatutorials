package com.ericaShy.java8.files;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 */
public class StreamInAndOut {

    public static void main(String[] args) {
        try (
            Stream<String> input = Files.lines(Paths.get("src/main/java/com/ericaShy/java8/files/StreamInAndOut.java"));
            PrintWriter output = new PrintWriter("src/main/resources/StreamInAndOut.txt")
        ) {
            input.map(String::toUpperCase)
                .forEachOrdered(output::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
