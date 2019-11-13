package com.ericaShy.java8.operators;

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {

    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}

public class Chess extends BoardGame{

    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }

    /**
     * 输出
     * Game constructor
     * BoardGame constructor
     * Chess constructor
     */
    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
