package com.ericaShy.java8.enums;

import java.util.EnumMap;

enum Category {
    MONEY(Input.NICKEL, Input.DIME, Input.QUARTER, Input.DOLLAR),
    ITEM_SELECTION(Input.TOOTHPASTE, Input.CHIPS, Input.SODA, Input.SOAP),
    QUIT_TRANSACTION(Input.ABORT_TRANSACTION),
    SHUT_DOWN(Input.STOP);

    private Input[] values;

    Category(Input... types) {
        values = types;
    }

    public static EnumMap<Input, Category> categories = new EnumMap<Input, Category>(Input.class);

    static {
        for (Category c : Category.class.getEnumConstants()) {
            for (Input type : c.values) {
                categories.put(type, c);
            }
        }
    }

    public static Category categories(Input input) {
        return categories.get(input);
    }

}

public class VendingMachine {
    private static State state = State.RESTING;

    private static int amount = 0;

    private static Input selection = null;

    enum StateDuration { TRANSIENT }

    enum State {
        RESTING {
            @Override
            void next(Input input) {
                switch (Category.categories(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            @Override
            void next(Input input) {
                switch (Category.categories(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()) {

                        }
                }
            }
        },
        TERMINAL {
            @Override
            void next(Input input) {

            }
        };

        abstract void next(Input input);
    }

    public static void main(String[] args) {
        System.out.println(Category.categories);
    }
}
