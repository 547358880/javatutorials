package com.ericaShy.java8.streams;

import java.util.ArrayList;

public class SpecialCollector {

    public static void main(String[] args) throws Exception {
        ArrayList<String> words =
                FileToWords.stream("/Chess.dat")
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        words.stream()
                .forEach(System.out::println);

        words.stream()
                .filter(s -> s.equals("cheese"))
                .forEach(System.out::println);

    }



}
