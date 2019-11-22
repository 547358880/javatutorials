package com.ericaShy.java8.streams;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 流的建造者模式
 */
public class FileToWordsBuilder {

    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(URI uri) throws Exception {
        Files.lines(Paths.get(uri))
                .skip(1)  // 跳过开头
                .forEach(line -> {
                    for(String w : line.split("[ .?,]+")) {
                        builder.add(w);
                    }
                });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        new FileToWordsBuilder(FileToWordsBuilder.class.getClassLoader().getResource("chess.dat").toURI())
                .stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
