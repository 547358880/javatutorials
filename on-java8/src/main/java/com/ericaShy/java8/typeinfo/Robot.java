package com.ericaShy.java8.typeinfo;

import com.ericaShy.java8.onjava.Null;

import java.util.List;

/**
 * Null值标记接口
 */
public interface Robot {

    String name();

    String model();

    List<Operation> operations();

    static void test(Robot r) {
        if (r instanceof Null) {
            System.out.println("[Null Robot]");
        }
        System.out.println("Robot name: " + r.name());
        System.out.println("Robot model: " + r.model());
        for (Operation operation : r.operations()) {
            System.out.println(operation.description.get());
            operation.command.run();
        }
    }

}
