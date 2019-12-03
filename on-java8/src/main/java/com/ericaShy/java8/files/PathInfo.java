package com.ericaShy.java8.files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo {

    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    static void info(Path p) {
        show("toString", p);
        show("Exists", Files.exists(p));
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("************************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        /**
         * 输出:
         * toString: F:\path\to\nowhere\NoFile.txt
         * Exists: true
         * RegularFile: true
         * Directory: false
         * Absolute: true
         * FileName: NoFile.txt
         * Parent: F:\path\to\nowhere
         * Root: F:\
         * ************************
         */
        info(Paths.get("F:", "path", "to", "nowhere", "NoFile.txt"));

        /**
         * toString: src\main\java\com\ericaShy\java8\files\PathInfo.java
         * Exists: true
         * RegularFile: true
         * Directory: false
         * Absolute: false
         * FileName: PathInfo.java
         * Parent: src\main\java\com\ericaShy\java8\files
         * Root: null
         * ************************
         */
        Path p = Paths.get("src/main/java/com/ericaShy/java8/files/PathInfo.java");
        info(p);

        /**
         * toString: F:\java-study\javatutorials\on-java8\src\main\java\com\ericaShy\java8\files\PathInfo.java
         * Exists: true
         * RegularFile: true
         * Directory: false
         * Absolute: true
         * FileName: PathInfo.java
         * Parent: F:\java-study\javatutorials\on-java8\src\main\java\com\ericaShy\java8\files
         * Root: F:\
         */
        Path ap = p.toAbsolutePath();
        info(ap);

        /**
         * toString: F:\java-study\javatutorials\on-java8\src\main\java\com\ericaShy\java8\files
         * Exists: true
         * RegularFile: false
         * Directory: true
         * Absolute: true
         * FileName: files
         * Parent: F:\java-study\javatutorials\on-java8\src\main\java\com\ericaShy\java8
         * Root: F:\
         */
        info(ap.getParent());

        /**
         * 输出:
         * toString: F:\java-study\javatutorials\on-java8\src\main\java\com\ericaShy\java8\files\PathInfo.java
         * Exists: true
         * RegularFile: true
         * Directory: false
         * Absolute: true
         * FileName: PathInfo.java
         * Parent: F:\java-study\javatutorials\on-java8\src\main\java\com\ericaShy\java8\files
         * Root: F:\
         */
        try {
            info(p.toRealPath());
        } catch (IOException e) {}

        URI u = p.toUri();
        System.out.println("URI: " + u);
        Path puri = Paths.get(u);
        /**
         * URI: file:///F:/java-study/javatutorials/on-java8/src/main/java/com/ericaShy/java8/files/PathInfo.java
         * true
         */
        System.out.println(Files.exists(puri));
        File f = ap.toFile();
    }
}
