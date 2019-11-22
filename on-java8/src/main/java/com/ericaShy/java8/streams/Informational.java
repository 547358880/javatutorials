package com.ericaShy.java8.streams;

public class Informational {

    public static void main(String[] args) throws Exception {
        System.out.println(FileToWords.stream("/Chess.dat").count());

        System.out.println(FileToWords.stream("/Chess.dat")
                    .min(String.CASE_INSENSITIVE_ORDER)
                    .orElse("NONE"));

        System.out.println(FileToWords.stream("/Chess.dat")
                .max(String.CASE_INSENSITIVE_ORDER)
                .orElse("NONE"));

    }

}
