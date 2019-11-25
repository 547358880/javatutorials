package com.ericaShy.jvm;

/**
 * 即使在可达性算法中不可发的对象，也并非是“非死不可”的，这个时候它们暂时处于“缓刑”要一个对象死亡， 至少要经历两次标记过程：
 * 1. 如果对象在进行可达性分析后发现没有与GC Roots相冠梁的引用链， 那它将会被第一次标记并且进行一次筛选，筛选的条件是此对象是否有必要执行finalize()方法,
 * 当对象没有覆盖finalize()方法,或者finalize方法已经被虚礼机调用过， 虚拟机将这两种情况视为"没有必要执行
 * 2. 如果这个对象被判定有必要执行finalize()方法， 那么这个对象会被放置在一个叫做F-Queue的队列之中，并且稍后由一个虚拟机自动建立的，低优先级的Finalizer线程去执行
 * finalize()方法是对象跳脱死亡命运的最后一次机会，稍后GC将对F-Queue中的对象进行第二次标记
 *
 * 参考: 深入理解Java虚拟机(P67)
 */

import com.ericaShy.java8.onjava.Nap;

/**
 * 此代码演示两点
 * 1. 对象可以在被GC自我救赎
 * 2. 这种机会只有一次, 因为一个对象的finalize()方法最多只会被系统调用一次
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();

        // 因为finalize方法优先级很低， 所以等待0.5秒
        new Nap(1);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead:(");
        }

        // 下面这段代码与上面完全相同，但这个救赎失败
        SAVE_HOOK = null;
        System.gc();

        // 因为finalize方法优先级很低， 所以等待0.5秒
        new Nap(1);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead:(");
        }
    }
}
