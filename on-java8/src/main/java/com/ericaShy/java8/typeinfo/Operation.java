package com.ericaShy.java8.typeinfo;

import java.util.function.Supplier;

public class Operation {

    public final Supplier<String> description;

    public final Runnable command;

    public Operation(Supplier<String> desc, Runnable cmd) {
        description = desc;
        command = cmd;
    }

}
