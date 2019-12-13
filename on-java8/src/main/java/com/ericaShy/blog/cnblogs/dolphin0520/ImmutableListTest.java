package com.ericaShy.blog.cnblogs.dolphin0520;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        System.out.println(list);

        List unmodifiableList = Collections.unmodifiableList(list);
        ImmutableList immutableList = ImmutableList.copyOf(list);

        list.add(2);
        System.out.println(unmodifiableList);
        System.out.println(immutableList);

    }

}
