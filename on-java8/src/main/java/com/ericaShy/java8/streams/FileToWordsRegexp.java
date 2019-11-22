package com.ericaShy.java8.streams;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 正则表达式
 */
public class FileToWordsRegexp {
    private String all;

    public FileToWordsRegexp(URI uri) throws Exception {
        all = Files.lines(Paths.get(uri))
                .skip(1)
                .collect(Collectors.joining(" "));
    }

    public Stream<String> stream() {
        return Pattern
                .compile("[ .,?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws Exception {
        FileToWordsRegexp fw = new FileToWordsRegexp(FileToWordsRegexp.class.getClassLoader().getResource("Chess.dat").toURI());
        fw.stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);

        fw.stream()
                .skip(7)
                .limit(2)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}

