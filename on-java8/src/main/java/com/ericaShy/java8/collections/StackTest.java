package com.ericaShy.java8.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StackTest {

    public static void main(String[] args) {
       Deque<String> stack = new ArrayDeque<>();
       for (String s : "My dog has fleas".split(" ")) {
           stack.push(s);
       }

       while (!stack.isEmpty()) {
           System.out.println(stack.pop() + " ");
       }
    }

}
