package com.ericaShy.java8.polymorphism;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * 一个对象被其他一个或多个对象共享时， 使用引用计数来跟踪仍然访问着共享对象的对象数量
 * cleaning up shared member objects
 */
class Shared {
    private int refCount = 0;
    private static long counter = 0;
    private final long id = counter++;

    Shared() {
        System.out.println("Creating " + this);
    }

    public void addRef() {
        refCount++;
    }

    protected void dispose() {
        if (--refCount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}

public class ReferenceCounting {
    /**
     * 输出:
     * Creating Shared 0
     * Creating Composing 0
     * Creating Composing 1
     * Creating Composing 2
     * Creating Composing 3
     * Creating Composing 4
     * disposing Composing 0
     * disposing Composing 1
     * disposing Composing 2
     * disposing Composing 3
     * disposing Composing 4
     * Disposing Shared 0
     */
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared)
        };

        for (Composing c: composing) {
            c.dispose();
        }
    }
}
