package com.ericaShy.java8.exceptions;

import com.ericaShy.ProgramConst;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputFile2 {

    private String fname;

    public InputFile2(String fname) {
        this.fname = fname;
    }

    public Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get(fname));
    }

    public static void main(String[] args) throws IOException {
        new InputFile2(ProgramConst.DIR + "/java8/exceptions/InputFile2.java")
                .getLines()
                .skip(21)
                .limit(1)
                .forEach(System.out::println);
    }
}
