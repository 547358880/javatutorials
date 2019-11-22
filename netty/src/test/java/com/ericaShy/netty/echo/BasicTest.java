package com.ericaShy.netty.echo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BasicTest
{
    @Test
    public void test1()
    {
        List<Integer> haha = new ArrayList<>();
        haha.add(1);
        haha.add(2);

        Object object = haha;

        List<Integer> test = (List<Integer>) object;

        Integer s = test.get(0);

        System.out.println(test);

    }
}
