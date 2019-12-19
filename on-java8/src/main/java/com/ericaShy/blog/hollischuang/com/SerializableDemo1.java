package com.ericaShy.blog.hollischuang.com;

import java.io.*;

/**
 * http://www.hollischuang.com/archives/1144
 *
 * 序列化破坏单例
 */
public class SerializableDemo1 {

    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f://tempFile"));
        oos.writeObject(Singleton.getSingleton());

        File file = new File("f://tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton newInstance = (Singleton) ois.readObject();

        // 判断是否是同一个对象
        // false
        System.out.println(newInstance == Singleton.getSingleton()); // 添加Singleton.readResolve后返回true
    }

}
