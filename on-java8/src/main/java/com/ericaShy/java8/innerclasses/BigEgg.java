package com.ericaShy.java8.innerclasses;

/**
 * 内部类被覆盖
 */
class Egg {
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    Egg() {
        System.out.println("new Egg()");
        y = new Yolk();
    }
}

public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    /**
     * 输出:
     * new Egg()
     * Egg.Yolk()
     */
    public static void main(String[] args) {
        new BigEgg();
    }
}
