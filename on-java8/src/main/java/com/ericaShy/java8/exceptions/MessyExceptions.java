package com.ericaShy.java8.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MessyExceptions {

    public static void main(String[] args) {
        InputStream in = null;

        try {
            in = new FileInputStream(new File("MessyExceptions.java"));
            int contents = in.read();
        } catch (IOException e) {

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {}
            }
        }
    }

}
