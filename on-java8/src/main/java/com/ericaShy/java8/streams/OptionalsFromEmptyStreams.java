package com.ericaShy.java8.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class OptionalsFromEmptyStreams {

    public static void main(String[] args) {
        Map<String, Object> results = new HashMap<>();
        results.put("success", null);
        results.put("message", null);


        System.out.println(Stream.<String>empty().findFirst());

        System.out.println("111");
    }

}
