package com.ericaShy.java8.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleRead {

    public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));

    public static void main(String[] args) {
        int i = 0;
        do {
            System.out.println(i++);
        } while (i < 8);


        try {
            System.out.println("What is your name?");
            String name = input.readLine();
            System.out.println(name);
            System.out.println("(input: <age> <double>");
            String numbers = input.readLine();
            System.out.println(numbers);
            String[] numArr = numbers.split(" ");
            int age = Integer.parseInt(numArr[0]);
            double favorite = Double.parseDouble(numArr[1]);
            System.out.format("Hi: %s.%n", name);
            System.out.format("In 5 years you will be %d.%n", age + 5);
            System.out.format("My favorite double is %f.%n", favorite / 2);

        } catch (IOException e) {
            System.err.println("I/O exception");
        }
    }

}
