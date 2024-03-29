package com.ericaShy.java8.collections;

import com.ericaShy.java8.typeinfo.pets.Cat;
import com.ericaShy.java8.typeinfo.pets.Dog;
import com.ericaShy.java8.typeinfo.pets.Hamster;
import com.ericaShy.java8.typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.Map;

public class PetMap {

    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        System.out.println(petMap);
        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));
    }

}
