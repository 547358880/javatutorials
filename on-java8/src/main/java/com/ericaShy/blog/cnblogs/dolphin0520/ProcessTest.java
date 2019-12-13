package com.ericaShy.blog.cnblogs.dolphin0520;

import java.io.IOException;
import java.util.Scanner;

public class ProcessTest {

    /**
     * Scanner用法见 java8.strings
     */
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ipconfig/all");
        Process process = pb.start();
        Scanner scanner = new Scanner(process.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();

    }

}
