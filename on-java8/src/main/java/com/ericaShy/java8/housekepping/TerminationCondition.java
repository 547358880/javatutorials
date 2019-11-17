package com.ericaShy.java8.housekepping;

import com.ericaShy.java8.onjava.Nap;

/**
 * 相关知识参考 com.ericaShy.jvm.FinalizeEscapeGC
 */
class Book {

    boolean checkedOut = false;

    Book(boolean checkedOut) {
        checkedOut = checkedOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("Error: checked out");
        }
    }
}

public class TerminationCondition {

    public static void main(String[] args) {
        Book novel = new Book(true);

        // Proper cleaup
        novel.checkIn();

        // Drop the reference, forget to clean up:
        new Book(true);
        // Force garbage collection & finalization:
        System.gc();

        new Nap(1);
    }
}
