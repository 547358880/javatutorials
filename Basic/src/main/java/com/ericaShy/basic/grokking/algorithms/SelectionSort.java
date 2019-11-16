package com.ericaShy.basic.grokking.algorithms;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
           int smallestIndex = findSmallest(arr, i);

           System.out.println("find small index " + smallestIndex + " and arr values " + Arrays.toString(arr));

           System.out.println("======================================");
           int temp = arr[i];
           arr[i] = arr[smallestIndex];
           arr[smallestIndex] = temp;
        }
        return arr;
    }

    public static int findSmallest(int[] arr, int j) {
        System.out.println("j=" + j);
        int smallestIndex = j;
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] < arr[smallestIndex]) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }
    public static void main(String[] args) {
        int[] testArr = new int[] {13, 5, 7, 2, 6, 9, 12};

        System.out.println(Arrays.toString(selectionSort(testArr)));
    }
}
