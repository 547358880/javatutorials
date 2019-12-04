package com.ericaShy.java8.enums.cartoons;

// An enum can implement an interface

import java.util.Random;
import java.util.function.Supplier;

enum CartoonCharacter implements Supplier<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY,
    SILLY, BOUNCY, MUTTY, BOB;

    private Random rand = new Random(47);

    @Override
    public CartoonCharacter get() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Supplier<T> rg) {
        System.out.print(rg.get() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
