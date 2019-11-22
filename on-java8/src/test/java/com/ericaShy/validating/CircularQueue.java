package com.ericaShy.validating;

/**
 * 1. 前置条件(用于put()): 不允许将空元素添加到队列中
 * 2. 前置条件(用于put()): 将元素放入完整队列是非法的
 * 3. 后置条件(用于get()): 试图从空队列中获取元素是非法的
 * 4. 后置条件(用于get()): 不能从数组中生成空元素
 * 5. 不变性: 包含对象的区域不能包含任何空元素
 * 6. 不变性: 不包含对象的区域必须只有空值
 */
public class CircularQueue {
    private Object[] data;
    private int in = 0,  // Next available storage space
        out = 0;
    private boolean wrapped = false;

    public CircularQueue(int size) {
        data = new Object[size];
        assert invariant();
    }

    private boolean invariant() {
        return true;
    }
}
