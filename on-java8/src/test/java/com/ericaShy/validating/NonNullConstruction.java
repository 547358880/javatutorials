package com.ericaShy.validating;

import static com.google.common.base.Preconditions.*;

public class NonNullConstruction {

    private Integer n;

    private String s;

    NonNullConstruction(Integer n, String s) {
        this.n = checkNotNull(n);
        this.s = checkNotNull(s);
    }

    public static void main(String[] args) {
        NonNullConstruction nnc = new NonNullConstruction(1, null);
    }

}
