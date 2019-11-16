package com.ericaShy.basic.algorithms4;

import java.util.Comparator;

/*
 * Sorts a sequence of string from input using selection sort
 *
 * % more tiny.txt
 * S O R T E X A M P L E
 *
 * % java Selection < tiny.txt
 * A E E L M O P R S T X
 */
public class Selection {

    private Selection() { }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }

            exch(a, i , min);
            assert isSorted(a, 0, i);
        }

        assert isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator
     * @param a the array
     */
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(comparator, a[j], a[min])) {
                    min = j;
                }
            }
        }
    }

    //exchange a[] i and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * Check if array is sorted - userful for debugging
     */
    //is the array a[] sorted
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false;
        return true;
    }

    //is v <　ｗ？
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Selection.sort(a);
        show(a);
    }
}
