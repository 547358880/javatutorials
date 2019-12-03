package com.ericaShy.java8.typeinfo;

import com.ericaShy.java8.onjava.Pair;
import com.ericaShy.java8.typeinfo.pets.LiteralPetCreator;
import com.ericaShy.java8.typeinfo.pets.Pet;
import com.ericaShy.java8.typeinfo.pets.Pets;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class.isInstance() 方法提供了一种动态测试对象类型的方法
 */
public class PetCount3 {

    static class Counter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        Counter() {
            super(LiteralPetCreator.ALL_TYPES.stream()
                    .map(lpc -> Pair.make(lpc, 0))
                    .collect(Collectors.toMap(Pair::key, Pair::value))
            );
        }

        public void count(Pet pet) {
            entrySet().stream()
                    .filter(pair -> pair.getKey().isInstance(pet))
                    .forEach(pair -> put(pair.getKey(), pair.getValue() + 1));
        }

        @Override
        public String toString() {
            String result = entrySet().stream()
                    .map(pair -> String.format("%s=%s", pair.getKey().getSimpleName(), pair.getValue()))
                    .collect(Collectors.joining(", "));
            return "{" + result + "}";
        }
    }



    public static void main(String[] args) {
        Counter petCount = new Counter();
        Pets.stream()
                .limit(20)
                .peek(petCount::count)
                .forEach(p -> System.out.print(p.getClass().getSimpleName() + " "));

        System.out.println();

        System.out.println(petCount);
    }
}
