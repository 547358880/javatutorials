package com.ericaShy.java8.enums;

import java.util.Random;

public enum Input {
    NICKEL(5), DIME(10), QUARTER(50), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        @Override
        int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {  // This must be the last instance
        @Override
        int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    int value;

    Input() {}

    Input(int value) {
        this.value = value;
    }

    int amount() {
        return value;
    }

    static Random rand = new Random(47);

    public static Input randomSelection() {
        // Don't include STOP
        return values()[rand.nextInt(values().length - 1)];
    }
}
