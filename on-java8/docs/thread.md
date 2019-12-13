## 线程

### 状态转换

- **新建(New)**: 创建后尚未启动的线程处于这种状态
- **运行(Runnable)**: Runnable包括了操作系统线程状态中的(Running(运行中)和Ready(就绪))两种状态, 此状态下的线程有可能正在执行或者等待CPU分配执行时间
- **无限期等待(Waiting)**: 此状态下的线程不会被分配CPU执行时间, 它们要等待被其他线程显示地唤醒，以下方法会让线程陷入无限期等待状态:
    - 没有设置Timeout参数的Object.wait()方法
    - 没有设置Timeout参数的Thread.join()方法
    - LockSupport.park()方法
- **限期等待(Timed Waiting)**: 此状态下的线程也不会分配CPU执行时间,不过无须等待被其他线程显示唤醒，在一定时间之后它们会由系统自动唤醒，以下方法会让线程进入限期等待状态:
    - Thread.sleep()方法(sleep方法不会释放锁)                                                                                                                                                                                                                                                                                                                    
    - 设置了Timeout参数的Object.wait()方法
    - 设置了Timeout参数的Thread.join()方法
    - LockSupport.parkNanos()方法
    - LockSupport.parkUntil()方法
- **阻塞(Blocked)**: 线程被阻塞,"阻塞状态"与"等待状态"的区别是："阻塞状态"在等待着获取到一个排他锁(不占CPU, 获取锁由系统进行调度和通知, 相关知识见深入理解计算机系统6.1.2)
- **结束(Terminated)**: 已终止的线程状态

![](https://img-blog.csdnimg.cn/20181120173640764.jpeg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3BhbmdlMTk5MQ==,size_16,color_FFFFFF,t_70)

备注:
- 对于synchronized方法或者synchronized代码块，当出现异常时,JVM会自动释放当前线程占用的锁

参考资料:
- [Java线程的6种状态及切换](https://blog.csdn.net/pange1991/article/details/53860651)
- 深入理解Java虚拟机12.4.3