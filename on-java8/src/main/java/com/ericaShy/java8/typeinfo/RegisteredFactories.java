package com.ericaShy.java8.typeinfo;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

class Part implements Supplier<Part> {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Supplier<? extends Part>> prototypes = Arrays.asList(

    );

    private static Random rand = new Random(47);

    @Override
    public Part get() {
        int n = rand.nextInt(prototypes.size());
        return prototypes.get(n).get();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    @Override
    public Part get() {
        return new FuelFilter();
    }
}


public class RegisteredFactories{

}
