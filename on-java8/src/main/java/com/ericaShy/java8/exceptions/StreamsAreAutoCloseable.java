package com.ericaShy.java8.exceptions;

import com.ericaShy.ProgramConst;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 一般流实例不需要在使用后关闭, 一般来说只用来源为IO通道的流(如Files.lines(Path, Charset)返回的流)才需要关闭
 * nearly(几乎) all stream instances do not actually(实际上,事实上) need to be closed after use,
 * generally, Only streams whose source is an IO channel(such as those return bu Files.lines()) will require closing
 *
 */
public class StreamsAreAutoCloseable {
    public static void main(String[] args) throws Exception {
        try (
            Stream<String> in = Files.lines(Paths.get(ProgramConst.DIR + "/java8/exceptions/StreamsAreAutoCloseable.java"));
            PrintWriter outfile = new PrintWriter(new File(StreamsAreAutoCloseable.class.getResource("/Results.txt").toURI()))
        ) {
            in.skip(18)
                .limit(1)
                .map(String::toLowerCase)
                .forEachOrdered(outfile::println);
        }
    }

}
