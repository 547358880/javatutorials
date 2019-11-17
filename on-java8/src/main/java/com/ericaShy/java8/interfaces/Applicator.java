package com.ericaShy.java8.interfaces;

import java.util.Arrays;

/**
 * 根据传入的参数类型从而具备不同行为的方法称为策略设计模式
 *
 * 方法包含算法不变的部分， 策略包含变化的部分
 */
class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    public Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    // 返回协变类型

    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class Applicator {

    public static void apply(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static void main(String[] args) {
        String s = "We are such stuff as dreams are made no";
        apply(new Upcase(), s);
        apply(new Downcase(), s);
        apply(new Splitter(), s);
    }
}
