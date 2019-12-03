package com.ericaShy.java8.generics;

/**
 * List实际上表示"持有任何Object类型的原生List"
 * List<?> 表示“具有某种特定类型的非原生List”
 */
public class Wildcards {

    // Raw argument
    static void rawArgs(Holder holder, Object arg) {

        // waring: unchecked acall to set(T) as a member of the raw type Holder
        //holder.set(arg);
        Object obj = holder.get();
    }


    public static void main(String[] args) {
        Holder raw = new Holder<>();
        // Or
        raw = new Holder();

        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
    }

}
