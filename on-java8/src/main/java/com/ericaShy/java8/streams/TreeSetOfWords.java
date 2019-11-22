package com.ericaShy.java8.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetOfWords {

    public static void main(String[] args) throws Exception {
        Set<String> words = Files.lines(Paths.get(TreeSetOfWords.class.getClassLoader().getResource("Chess.data").toURI()))
            .flatMap(s -> Arrays.stream(s.split("\\W+")))
            .peek(System.out::println)
            .filter(s -> !s.matches("\\d+"))
            .map(String::trim)
            .filter(s -> s.length() > 2)
            .limit(10)
            .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(words);
    }

}
