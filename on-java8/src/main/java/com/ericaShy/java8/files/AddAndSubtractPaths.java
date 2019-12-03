package com.ericaShy.java8.files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Paths的增减修改
 */
public class AddAndSubtractPaths {
    static Path base = Paths.get("..", "..", "..").toAbsolutePath().normalize();

    static void show(int id, Path result) {
        if (result.isAbsolute()) {
            System.out.println("(" + id + ")r " + base.relativize(result));
        } else {
            System.out.println("(" + id + ")" + result);
        }

        try {
            System.out.println("RealPath: " + result.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws IOException {
        System.out.println(base);
    }

}
