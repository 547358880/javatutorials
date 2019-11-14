package com.ericaShy.java8.interfaces.interfaceprocessor;

import java.util.Arrays;

/**
 * 备注：
 * [1] 该声明不是必要的， 即使移除它， 编译器不会报错
 */
interface StringProcessor extends Processor {

    @Override
    Object process(Object input);  //[1]

    String S = "If she weighs the same as a duck, she's mad of wood"; //[2]

    static void main(String[] args) {   // [3]
        Applicator.apply(new Upcase(), S);
        Applicator.apply(new Downcase(), S);
        Applicator.apply(new Splitter(), S);
    }
}

class Upcase implements StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase implements StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter implements StringProcessor {
    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

