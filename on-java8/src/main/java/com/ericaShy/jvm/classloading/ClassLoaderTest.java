package com.ericaShy.jvm.classloading;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    System.out.println(fileName);
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }

            @Override
            protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                // 首先检查请求的类是否已经被加载过了
                Class c = findLoadedClass(name);
                if (c == null) {
                    try {
                        if (getParent() != null) {
//                            c = getParent().loadClass(name, false);
                        } else {
//                            findBoot
                        }
                    } catch (Exception e) {
                        // 如果父类加载器抛出ClassNotFountException说明父类加载器无法完成加载请求
                    }

                    if (c == null) {
                        // 父类加载器无法加载的时候再调用本省的findClass方法来进行加载
                        c = findClass(name);
                    }
                }

                if (resolve) {
                    resolveClass(c);
                }

                return c;
            }
        };

        Object obj = myLoader.loadClass("com.ericaShy.jvm.classloading.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        /**
         * 虚拟机中存在两个ClassLoaderTest类
         */
        System.out.println(obj instanceof com.ericaShy.jvm.classloading.ClassLoaderTest); // false

        String aa = "test";
        System.out.println(ClassLoaderTest.class.getClassLoader()); // sun.misc.Launcher$AppClassLoader@14dad5dc
    }

}
