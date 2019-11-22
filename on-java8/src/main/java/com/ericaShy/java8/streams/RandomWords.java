package com.ericaShy.java8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomWords implements Supplier<String> {

    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    /**
     *
     * 注：
     * 类加载器读取资源文件不适合装载大文件，否则会导致jvm内存溢出
     */
    RandomWords(String fname) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource(fname).toURI()));
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+")) {
                words.add(word.toLowerCase());
            }
        }
    }

    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return words.stream()
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(
                Stream.generate(new RandomWords("Chess.dat"))
                    .limit(10)
                    .collect(Collectors.joining(" "))
        );
    }
}
