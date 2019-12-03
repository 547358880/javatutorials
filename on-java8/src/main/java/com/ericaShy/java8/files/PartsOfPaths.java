package com.ericaShy.java8.files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 选取路径部分片段
 */
public class PartsOfPaths {

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));

        Path p = Paths.get("src/main/java/com/ericaShy/java8/files/PartsOfPaths.java").toAbsolutePath();

        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }

        System.out.println("ends with '.java': " + p.endsWith(".java"));

        System.out.println("****************************");

        System.out.println(p);
        for (Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }

        System.out.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));

    }

}
