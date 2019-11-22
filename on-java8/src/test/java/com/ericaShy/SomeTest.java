package com.ericaShy;

import org.junit.jupiter.api.Test;

public class SomeTest {

    @Test
    public void testResolveName() {
        int[] testIntArr = new int[0];
        String[] testIntegerArr = new String[0];

        System.out.println("name = " + testIntArr.getClass().getName() + ",simpleNme = " + testIntArr.getClass().getSimpleName()
                + ", typeName =" + testIntArr.getClass().getTypeName()
                + ", canonicalName =" + testIntArr.getClass().getCanonicalName());

        System.out.println("name = " + testIntegerArr.getClass().getName() + ", simpleNme = " + testIntegerArr.getClass().getSimpleName()
                + ", typeName =" + testIntegerArr.getClass().getTypeName()
                + ", canonicalName =" + testIntegerArr.getClass().getCanonicalName());
    }

}
