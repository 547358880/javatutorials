package com.ericaShy.java8.files;

import java.nio.file.*;

/**
 * 文件查找
 */
public class Find {

    public static void main(String[] args) throws Exception {
        Path test = Paths.get("test");
        Directories.refreshTestDir();
        Directories.populateTestDir();

        //Creating a *directory*, not a file:
        /**
         *   **"/ 表示当前目录以及所有子目录
         */
        Files.createDirectory(test.resolve("dir.tmp"));
        PathMatcher matcher = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.{tmp,txt}");
        Files.walk(test)
            .filter(matcher::matches)
            .forEach(System.out::println);
        System.out.println("**************************");

        PathMatcher matcher2 = FileSystems.getDefault()
                .getPathMatcher("glob:*.tmp");
        Files.walk(test)
            .map(Path::getFileName)
            .filter(matcher2::matches)
            .forEach(System.out::println);
        System.out.println("***************************");

        Files.walk(test)            // Only look for files
            .filter(Files::isRegularFile)
            .map(Path::getFileName)
            .filter(matcher2::matches)
            .forEach(System.out::println);
    }

}
