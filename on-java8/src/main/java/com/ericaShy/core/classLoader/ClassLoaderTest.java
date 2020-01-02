//package classLoader;
package com.ericaShy.core.classLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
      //  System.out.println("dasdasd");
        CryptoClassLoader loader = new CryptoClassLoader(2);
        byte[] test = loader.loadClassBytes("classLoader.Calculator");
        System.out.println(test.length);
    }
}

// This class loader loads encrypted class files
class CryptoClassLoader extends ClassLoader {
    private int key;

    public CryptoClassLoader(int k) {
        key = k;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classBytes = null;
            classBytes = loadClassBytes(name);
            Class<?> cl = defineClass(name, classBytes, 0, classBytes.length);
            if (cl == null) throw new ClassNotFoundException(name);
            return cl;
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    /**
     * Loads and decrypt the class file bytes
     */
    public byte[] loadClassBytes(String name) throws IOException {
        String cname = name.replace(".", "/") + ".caesar";
        byte[] bytes = Files.readAllBytes(Paths.get(cname));
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - key);
        }
        return bytes;
    }
}