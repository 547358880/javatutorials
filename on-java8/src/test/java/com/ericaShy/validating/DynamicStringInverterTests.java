package com.ericaShy.validating;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;

public class DynamicStringInverterTests {

    Stream<DynamicTest> testVersions(String id,
                                     Function<StringInverter, String> test) {
        List<StringInverter> versions = Arrays.asList(new Inverter1(), new Inverter2(), new Inverter3(), new Inverter4());
        return DynamicTest.stream(versions.iterator(),
                inverter -> inverter.getClass().getSimpleName(),
                inverter -> {
                    System.out.println(inverter.getClass().getSimpleName() + ": " + id);
                    try {
                        if (test.apply(inverter) != "fail") {
                            System.out.println("Success");
                        }
                    } catch (Exception | Error e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                }
        );
    }


    @BeforeAll
    static void startMsg() {
        System.out.println(">>> Starting DynamicStringInverterTests <<<");
    }

    @AfterAll
    static void endMsg() {
        System.out.println(">>> Finished DunamicStringInverterTests <<<");
    }

    String isEqual(String lval, String rval) {
        if (lval.equals(rval)) {
            return "success";
        }
        System.out.println("FAIL: " + lval + " != " + rval);
        return "fail";
    }

    @TestFactory
    Stream<DynamicTest> basicInversion1() {
        String in = "Exit, Pursued by a Bear";
        String out = "eXIT, pURSUED BY A bEAR";
        return testVersions("Basic inversion (should succeed)",
                inverter -> isEqual(inverter.invert(in), out));
    }


}
