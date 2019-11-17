package com.ericaShy.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * 参数-XX:+HeapDumpOnOutOfMemoryError可让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后分析
 */
public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
