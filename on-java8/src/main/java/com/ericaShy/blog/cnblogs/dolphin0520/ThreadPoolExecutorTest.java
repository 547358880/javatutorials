package com.ericaShy.blog.cnblogs.dolphin0520;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolExecutorTest extends AbstractExecutorService {
    volatile int runState;

    /*
     *   线程池的状态
     *
     *   参考:[线程池的使用](https://www.cnblogs.com/dolphin0520/p/3932921.html)
     */
    static final int RUNNING = 0;
    static final int SHUTDOWN = 1;
    static final int STOP = 2;
    static final int TERMINATED = 3;

    private BlockingQueue<Runnable> workQueue; // 任务缓存队列,用来存放等待执行的任务
    private ReentrantLock mainLock = new ReentrantLock(); // 线程池的主要状态锁,对线程池状态的改变都要用到这个锁
    private HashSet<Worker> workers = new HashSet<Worker>();  //用来存放工作集

    private volatile long keepAliveTime; //线程存活时间
    private volatile boolean allowCoreThreadTimeOut; //是否允许为线程池设置存活时间

    /**
     * corePoolSize在很多地方被翻译成核心池大小，其实我的理解这个就是线程池的大小。举个简单的例子：
     *  假如有一个工厂，工厂里面有10个工人，每个工人同时只能做一件任务。
     * 因此只要当10个工人中有工人是空闲的，来了任务就分配给空闲的工人做；
     * 当10个工人都有任务在做时，如果还来了任务，就把任务进行排队等待；
     * 如果说新任务数目增长的速度远远大于工人做任务的速度，那么此时工厂主管可能会想补救措施，比如重新招4个临时工人进来；
     * 然后就将任务也分配给这4个临时工人做；
     * 如果说着14个工人做任务的速度还是不够，此时工厂主管可能就要考虑不再接收新的任务或者抛弃前面的一些任务了。
     * 当这14个工人当中有人空闲时，而新任务增长的速度又比较缓慢，工厂主管可能就考虑辞掉4个临时工了，只保持原来的10个工人，毕竟请额外的工人是要花钱的。
     * 这个例子中的corePoolSize就是10，而maximumPoolSize就是14（10+4）。
     * 也就是说corePoolSize就是线程池大小，maximumPoolSize在我看来是线程池的一种补救措施，即任务量突然过大时的一种补救措施。
     */
    private volatile int corePoolSize;  // 核心吃的大小(即线程池中的线程数目大于这个参数时， 提交的任务会被放进任务缓存队列)
    private volatile int maxinumPoolSize;  //线程池最大线程数

    private volatile int poolSize; // 线程池中当前的线程数
    private volatile RejectedExecutionHandler handler; //拒绝策略
    private volatile ThreadFactory threadFactory; // 线程工厂,用来创建线程

    private int largetPoolSize; //用来记录线程池中曾经穿线过最大线程数
    private long completedTaskCount; // 用来记录已经执行完毕的任务个数

    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }

        /**
         * 如果当前线程数不小于核心池大小
         */
        if (poolSize >= corePoolSize || !addIfUnderCorePoolSize(command)) {
            /**
             * 放入缓存队列
             */
            if (runState == RUNNING && workQueue.offer(command)) {
                //这句判断是为了防止在将此任务添加进任务缓存队列的同时其他线程突然调用shutdown或者shutdownNow方法关闭了线程池的一种应急措施。如果是这样就执行：
                if (runState != RUNNING || poolSize == 0) {
                    // 进行应急处理，从名字可以看出是保证 添加到任务缓存队列中的任务得到处理
                    /**
                     * ensure(保证)
                     */
                    ensureQueuedTaskHandled(command);
                }
            } else if (!addIfUnderMaximumPoolSize(command)) {
                // 任务拒绝处理
                reject(command);
            }
        }

    }

    private void ensureQueuedTaskHandled(Runnable command) {

    }

    private void reject(Runnable command) {

    }

    private boolean addIfUnderCorePoolSize(Runnable firstTask) {
        Thread t = null;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            if (poolSize < corePoolSize && runState == RUNNING) {
                t = addThread(firstTask); // 创建线程去执行firstTask任务
            }
        } finally {
            mainLock.unlock();
        }
        if (t == null) {
            return false;
        }
        t.start();
        return true;
    }

    private Thread addThread(Runnable firstTask) {
        Worker w = new Worker(firstTask);
        Thread t = threadFactory.newThread(w);  // 创建一个线程,执行任务
        if (t != null) {
            w.thread = t;
            workers.add(w);
            int nt = ++poolSize; // 当前线程数加1
            if (nt > largetPoolSize) {
                largetPoolSize = nt;
            }
        }
        return t;
    }

    private final class Worker implements Runnable {
        private final ReentrantLock runLock = new ReentrantLock();
        private Runnable firstTask;
        volatile long completeTasks;
        Thread thread;

        Worker(Runnable firstTask) {
            this.firstTask = firstTask;
        }

        boolean isActive() {
            return runLock.isLocked();
        }

        void interruptIfIdle() {
            final ReentrantLock runLock = this.runLock;
            if (runLock.tryLock()) {
               try {
                   if (thread != Thread.currentThread()) {
                       thread.interrupt();
                   }
               }  finally {
                   runLock.unlock();
               }
            }
        }

        private void runTask(Runnable task) {
            final ReentrantLock runLock = this.runLock;
            runLock.lock();
            try {

                boolean ran = false;
            //    beforeExecute(thread, task);   //beforeExecute方法是ThreadPoolExecutor类的一个方法，没有具体实现，用户可以根据
                //自己需要重载这个方法和后面的afterExecute方法来进行一些统计信息，比如某个任务的执行时间等

                try {
                    task.run();
                    ran = true;
            //        afterExecute(task, null);
                    ++completedTaskCount;
                } catch (RuntimeException ex) {
                    if (!ran) {
            //            afterExecute(task, ex);
                    }

                    throw ex;
                }

            } finally {
                runLock.unlock();
            }
        }

        @Override
        public void run() {
            try {
                Runnable task = firstTask;
                firstTask = null;
                while (task != null || (task = getTask()) != null) {
                    runTask(task);
                    task = null;
                }
            } finally {
     //           workerDone(this); // 当队列中没有任务时，进行清理工作
            }
        }
    }

    Runnable getTask() {
        for (;;) {
            try {
                int state = runState;
                if (state > SHUTDOWN) {
                    return null;
                }
                Runnable r;
                if (state == SHUTDOWN) {
                    r = workQueue.poll();
                } else if (poolSize > corePoolSize || allowCoreThreadTimeOut) {
                    r = workQueue.poll(keepAliveTime, TimeUnit.SECONDS);
                } else {
                    r = workQueue.take();
                }

                if (r != null) {
                    return r;
                }

                if (workerCanExit()) {      //如果没取到任务，即r为null，则判断当前的worker是否可以退出
                    if (runState >= SHUTDOWN) {
                        interruptIdleWorkers();   //中断处于空闲状态的worker
                    }
                    return null;
                }

            } catch (InterruptedException e) {}
        }
    }

    void interruptIdleWorkers() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            for (Worker w : workers) {
                w.interruptIfIdle();
            }
        } finally {
            mainLock.unlock();
        }
    }

    private boolean workerCanExit() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        boolean canExit;
        //如果runState大于等于STOP，或者任务缓存队列为空了
        //或者  允许为核心池线程设置空闲存活时间并且线程池中的线程数目大于1
        try {
            canExit = runState >= STOP || workQueue.isEmpty() || (allowCoreThreadTimeOut && poolSize > Math.max(1, corePoolSize));
        } finally {
            mainLock.unlock();
        }
        return canExit;
    }

    private boolean addIfUnderMaximumPoolSize(Runnable firstTask) {
        Thread t = null;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            if (poolSize < maxinumPoolSize && runState == RUNNING) {
                t = addThread(firstTask);
            }
        } finally {
            mainLock.unlock();
        }
        if (t == null) {
            return false;
        }
        t.start();
        return true;
    }



    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public static void main(String[] args) {
//        ThreadPoolExecutor
    }
}
