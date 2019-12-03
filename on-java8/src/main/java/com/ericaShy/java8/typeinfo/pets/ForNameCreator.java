package com.ericaShy.java8.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
        "com.ericaShy.java8.typeinfo.pets.Mutt",
            "com.ericaShy.java8.typeinfo.pets.Mutt",
            "com.ericaShy.java8.typeinfo.pets.Pug",
            "com.ericaShy.java8.typeinfo.pets.EgyptianMau",
            "com.ericaShy.java8.typeinfo.pets.Manx",
            "com.ericaShy.java8.typeinfo.pets.Cymric",
            "com.ericaShy.java8.typeinfo.pets.Rat",
            "com.ericaShy.java8.typeinfo.pets.Mouse",
            "com.ericaShy.java8.typeinfo.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
