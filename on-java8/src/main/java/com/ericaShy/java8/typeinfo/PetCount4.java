package com.ericaShy.java8.typeinfo;

import com.ericaShy.java8.typeinfo.pets.Pet;
import com.ericaShy.java8.typeinfo.pets.Pets;

public class PetCount4 {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);

        Pets.stream()
                .limit(20)
                .peek(counter::count)
                .forEach(p -> System.out.print(p.getClass().getSimpleName() + " "));

        System.out.format("%n" + counter);
    }

}
