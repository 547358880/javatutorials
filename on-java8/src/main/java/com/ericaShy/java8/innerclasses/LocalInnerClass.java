package com.ericaShy.java8.innerclasses;

/**
 * 局部内部类不能有访问说明符， 因为它不是外围类的一部分， 但是它可以访问当权代码块的常量以及此外围类的所有成员
 */

interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    Counter getCounter(final String name) {
        // A local inner class:
        class LocalCounter implements Counter {
            LocalCounter() {
                // Local inner class can have a constrcutor
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        }
        return new LocalCounter();
    }

    Counter getCounter2(final String name) {
        return new Counter() {
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        };
    }

    /**
     * 输出:
     * LocalCounter()
     * Counter()
     * Local inner 0
     * Local inner 1
     * Local inner 2
     * Local inner 3
     * Local inner 4
     * Anonymous inner 5
     * Anonymous inner 6
     * Anonymous inner 7
     * Anonymous inner 8
     * Anonymous inner 9
     */
    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("Local inner "),
                c2 = lic.getCounter2("Anonymous inner ");

        for (int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }
}
