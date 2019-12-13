## 内存

### 内存模型(Java Memory Model, JMM)

1. happens-before原则(先行发生原则)
    - 程序次序规则:一个线程内，按照代码顺序，书写在前面的操作先行发生与书写在后面的操作
    - 锁定规则: 一个unLock操作先行发生与后面对同一个锁的lock操作
    - volatile变量规则: 对一个变量的写操作先行发生与后面对这个变量的读操作
    - 传递规则: 如果A先行发生与B,而B先行发生与C, 则可以得出操作A先行发生与C
    - 线程启动规则: Thread对象的start()方法先行发生于此线程的没一个动作
    - 线程中断规则: 对线程interrput()方法的调用先行发生于被中断线程的代码检测到中断事件的发生
    - 线程终结规则: 线程中所有的操作都先行发生与线程的终止检测，可以通过Thread.join()方法结束,Thread.isAlive()的返回值等手段检测到线程已经终止执行
    - 对象终结规则：一个对象的初始化完成先行发生于它的finalize()方法的开始

相关资料: 
- 深入理解Java虚拟机12.3.6
- [Java并发编程：volatile关键字解析](https://www.cnblogs.com/dolphin0520/p/3920373.html)    

### Java Direct Memory
相关资料
- [Java NIO中，关于DirectBuffer，HeapBuffer的疑问？](https://www.zhihu.com/question/57374068/answer/152691891)
- [深入浅出MappedByteBuffer](https://www.jianshu.com/p/f90866dcbffc)
- [蚂蚁二面，面试官问我零拷贝的实现原理，当场懵了…](https://www.jianshu.com/p/2581342317ce)
- [Java IO 学习（六）Java的Direct Memory与IO](https://www.cnblogs.com/stevenczp/p/7506280.html)