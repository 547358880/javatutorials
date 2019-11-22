package com.ericaShy.java8.streams;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileToWords {

    public static Stream<String> stream(String fileName) throws Exception {
        /**
         * 输出:
         * file:/F:/java-study/javatutorials/on-java8/target/classes/com/ericaShy/java8/streams/
         * file:/F:/java-study/javatutorials/on-java8/target/classes/
         * file:/F:/java-study/javatutorials/on-java8/target/classes/
         */
//        System.out.println(FileToWords.class.getResource(""));
//        System.out.println(FileToWords.class.getResource("/"));
//        System.out.println(FileToWords.class.getClassLoader().getResource(""));
        return Files.lines(Paths.get(FileToWords.class.getResource(fileName).toURI()))
                .skip(1)
                .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));
    }

    public static Stream<String> stream(URI uri) throws Exception {
        return Files.lines(Paths.get(uri))
                .skip(1)
                .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));
    }
}
