package com.ericaShy.java8.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * File 文件和目录路径名的抽象表现形式
 */
public class DirList {

    public static void main(String[] args) {
        // 路径分隔符
        // 详细见 com.ericaShy.java8.objects.ShowProperties
//        System.out.println(File.pathSeparatorChar);
//        System.out.println(System.getProperty("file.separator"));
        File path = new File(".");
        String[] list = path.list();

        System.out.println(Arrays.toString(list));

    }

    private class DirFilter implements FilenameFilter {
        private Pattern pattern;

        public DirFilter(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}
