package com.ericaShy.java8.arrays;

import com.ericaShy.java8.onjava.Count;

import java.util.Arrays;

import static com.ericaShy.java8.onjava.ArrayShow.*;

/**
 * reduce()方法: 它对前一个元素和当前元素执行一个操作,并将结果放入当前元素位置
 */
public class ParallelPrefix1 {

    public static void main(String[] args) {
        int[] nums = new Count.Pint().array(10);
        show(nums);

        System.out.println(Arrays.stream(nums).reduce(Integer::sum).getAsInt());

        // parallelPrefix相当于reduce
        Arrays.parallelPrefix(nums, Integer::sum);
        show(nums);
    }

}
