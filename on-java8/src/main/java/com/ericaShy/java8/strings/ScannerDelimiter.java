package com.ericaShy.java8.strings;

import java.util.Scanner;

/**
 * Scanner分隔符(默认的是根据空白字符进行分词)
 */
public class ScannerDelimiter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNextInt()) {
            System.out.println(scanner.nextInt());
        }
    }

}
