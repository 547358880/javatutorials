package com.ericaShy.java8.exceptions;

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

public class Human {

    /**
     * 输出:
     * Caught sneeze
     * Caught Annoyance
     */
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("Caught sneeze");
        } catch (Annoyance e) {
            System.out.println("Caught Annoyance");
        }

        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }

}
