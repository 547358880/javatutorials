package com.ericaShy;


import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {

    /**
     * 随机数种子
     */
    @Test
    public void haha() {
        Random test = new Random();
        Random test1 = new Random(123456);

        System.out.println(test.nextInt());
        System.out.println(test1.nextInt());

        System.out.println(Math.random());

        // 8 * 60 * 60 = 28800
        System.out.println(System.currentTimeMillis() - System.nanoTime());
    }
}
