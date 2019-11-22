package com.ericaShy.java8.exceptions;

//guaranteeing(保证) proper(正确的) cleanup of a resource
public class Cleanup {

    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("Cleannup.java");

            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) {
                    ;
                }
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }

        } catch (Exception e) {
            System.out.println("Input construction failed");
        }
    }

}
