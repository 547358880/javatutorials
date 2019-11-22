package com.ericaShy.java8.collections;

import com.ericaShy.java8.typeinfo.pets.Hamster;
import com.ericaShy.java8.typeinfo.pets.Pet;
import com.ericaShy.java8.typeinfo.pets.Pets;
import com.ericaShy.java8.typeinfo.pets.Rat;

import java.util.LinkedList;

public class LinkedListFeatures {

    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(Pets.list(5));
        System.out.println(pets);

        System.out.println("pet.getFirst(): " + pets.getFirst());
        System.out.println("pets.element(): " + pets.element());

        // peek() 获取但不移除列表的头(第一个元素), 如果列表为空, 返回null
        System.out.println("pets.peek(): " + pets.peek());
        //remove and return the first element:
        System.out.println("peek.remove(): " + pets.remove());
        System.out.println("pets.removeFirst(): " + pets.removeFirst());
        System.out.println("pets.poll(): " + pets.poll());
        System.out.println(pets);

        pets.addFirst(new Rat());
        System.out.println("After addFirst(): " + pets);
        //将指定元素添加到此列表的末尾（最后一个元素）
        pets.offer(Pets.get());
        System.out.println("After offer(): " + pets);
        pets.add(Pets.get());
        System.out.println("After add(): " + pets);
        pets.addLast(new Hamster());
        System.out.println("After addLast(): " + pets);
    }

}
