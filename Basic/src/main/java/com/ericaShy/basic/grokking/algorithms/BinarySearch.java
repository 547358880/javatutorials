package com.ericaShy.basic.grokking.algorithms;

/**
 * 二分查找
 */
public class BinarySearch {

    public static Integer binarySearch(int[] intArray, int item) {
        int low = 0;
        int high = intArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guest = intArray[mid];
            if (guest == item) {
                return mid;
            }

            if (guest > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] myList = new int[] {1, 3, 5, 7, 9};
        System.out.println(binarySearch(myList, 3));
        System.out.println(binarySearch(myList, -1));
    }
}
