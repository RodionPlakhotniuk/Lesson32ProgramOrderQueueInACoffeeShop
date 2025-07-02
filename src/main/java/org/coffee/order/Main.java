package org.coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.add("Родіон");
        board.add("Каріна");
        board.add("Бруна");

        board.draw();

        board.deliver();
        board.deliver(3);

        board.draw();
    }
}
