package com.ericaShy.blog.cnblogs.dolphin0520;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class ModificationExceptionTest {

    /**
     * Exception in thread "main" java.util.ConcurrentModificationException
     * 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
     * 	at java.util.ArrayList$Itr.next(ArrayList.java:851)
     * 	at com.ericaShy.blog.cnblogs.dolphin0520.ModificationExceptionTest.test1(ModificationExceptionTest.java:13)
     * 	at com.ericaShy.blog.cnblogs.dolphin0520.ModificationExceptionTest.main(ModificationExceptionTest.java:22)
     */
    public static void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                list.remove(integer);
            }
        }
    }

    public static void test2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                iterator.remove();
            }
        }
    }


    public static void main(String[] args) {
        test2();

//        ArrayBlockingQueue
    }

}
