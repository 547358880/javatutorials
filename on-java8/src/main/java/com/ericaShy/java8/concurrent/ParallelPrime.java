package com.ericaShy.java8.concurrent;

import com.ericaShy.java8.onjava.Timer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.LongStream.*;

public class ParallelPrime {

    static final int COUNT = 100000;

    public static boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        List<String> primes = iterate(2, i -> i + 1)
                .parallel()
                .filter(ParallelPrime::isPrime)
                .limit(COUNT)
                .mapToObj(Long::toString)
                .collect(Collectors.toList());
        System.out.println(timer.duration());
        Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);
    }
}
