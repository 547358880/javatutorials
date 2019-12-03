package com.ericaShy.java8.strings;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.print.DocFlavor;
import java.util.Formatter;

/**
 * 二进制转十六进制
 */
public class Hex {

    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) {
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(format(new byte[]{1, -127}));

        System.out.println();

        char test = 'a';
        new Formatter(System.out).format("%h%n", test);
    }

}
