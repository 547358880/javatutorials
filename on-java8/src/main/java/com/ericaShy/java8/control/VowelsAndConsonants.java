package com.ericaShy.java8.control;

import java.util.Random;

public class VowelsAndConsonants {

    public static void main(String[] args) {
        /**
         * 输出:
         * y, 121:
         * Sometimes vowel
         * consonant
         */
        Random rand = new Random(47);
        for (int i = 0; i < 1; i++) {
            int c = rand.nextInt(26) + 'a';
            System.out.println((char) c + ", " + c + ": ");
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("vowel");
                    break;
                case 'y':
                case 'w':
                    System.out.println("Sometimes vowel");
                default:
                    System.out.println("consonant");
            }
        }
    }

}
