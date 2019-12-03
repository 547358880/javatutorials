package com.ericaShy.java8.typeinfo;

import com.ericaShy.java8.typeinfo.pets.ForNameCreator;
import com.ericaShy.java8.typeinfo.pets.Pet;
import com.ericaShy.java8.typeinfo.pets.PetCreator;
import com.ericaShy.java8.typeinfo.pets.Pets;

import java.util.HashMap;

/**
 * 使用instanceof
 */
public class PetCount {

    static class Counter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    static void countPets(PetCreator creator) {
        Counter counter = new Counter();
        for (Pet pet : Pets.array(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet) {
                counter.count("Pet");
            }
        }
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
