package com.ericaShy.java8.strings;

import java.util.Formatter;

/**
 * 格式化修饰符
 * %[argument_index$][flags][width][.precision]conversion
 *
 */
public class ReceiptBuilder {
    private double total = 0;
    private Formatter f = new Formatter(new StringBuilder());

    public ReceiptBuilder() {
        f.format("%-15s | %5s | %10s%n", "Item", "Qty", "Price");
        f.format("%-15s | %5s | %10s%n", "----", "---", "-----");
    }

    public void add(String name, int qty, double price) {
        f.format("%-15.15s | %5d | %10.2f%n", name, qty, price);
        total += price * qty;
    }

    public String build() {
        return f.toString();
    }

    public static void main(String[] args) {
        ReceiptBuilder receiptBuilder = new ReceiptBuilder();
        receiptBuilder.add("Jack's Magic Beans", 4, 4.256);
        receiptBuilder.add("Princess Peas", 3, 5.1);
        receiptBuilder.add("Three Bears Porridge", 1, 14.29);
        System.out.println(receiptBuilder.build());
    }

}
