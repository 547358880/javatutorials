package com.ericaShy.java8.interfaces.interfaceprocessor;

import com.ericaShy.java8.interfaces.filters.Filter;
import com.ericaShy.java8.interfaces.filters.HighPass;
import com.ericaShy.java8.interfaces.filters.LowPass;
import com.ericaShy.java8.interfaces.filters.Waveform;
import com.sun.org.apache.bcel.internal.generic.IFLE;

/**
 * 在类库是被发现的然不是被创建的， 这种不能修改类库的情况下， 可以使用适配器模式
 * 适配器允许代码接受已有的接口产生需要的接口
 *
 * 下面的是对象适配器
 */
class FilterAdapter implements Processor {
    Filter filter;

    FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}

public class FilterProcessor {

    public static void main(String[] args) {
        Waveform w = new Waveform();
        Applicator.apply(new FilterAdapter(new LowPass(1.0)), w);
        Applicator.apply(new FilterAdapter(new HighPass(2.0)), w);
    }
}
