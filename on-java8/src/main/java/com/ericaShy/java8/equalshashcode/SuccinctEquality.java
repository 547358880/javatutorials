package com.ericaShy.java8.equalshashcode;

import java.util.Objects;

/**
 * && 是一个短路比较,它会在第一次遇到失败的时候退出并返回false
 */
public class SuccinctEquality extends Equality {

    public SuccinctEquality(int i, String s, double d) {
        super(i, s, d);
        System.out.println("made 'SuccinctEquality'");
    }

    @Override
    public boolean equals(Object rval) {
        return rval instanceof SuccinctEquality &&
                Objects.equals(i, ((SuccinctEquality) rval).i) &&
                Objects.equals(s, ((SuccinctEquality) rval).s) &&
                Objects.equals(d, ((SuccinctEquality) rval).d);
    }
}
