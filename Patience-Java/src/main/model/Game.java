package main.model;

import main.exception.EmptyCardStackException;

import java.util.ArrayList;

public class Game {
    private GameTable gameTable;
    private Deck deck;
    
    public Game(Deck deck, GameTable table) {
        this.deck = deck;
        this.gameTable = table;
    }

    public boolean stacksMergeable(Stack stack1, Stack stack2) {
        int positionDifference = Math.abs(stack2.getPosition() - stack1.getPosition());

        if (!(positionDifference == 1 || positionDifference == 3)) {
            return false;
        }

        Card card1;
        Card card2;

        try {
            card1 = stack1.getTop();
            card2 = stack2.getTop();
        } catch (EmptyCardStackException ex) {
            return false;
        }

        return card1.getColor() == card2.getColor() || card1.getValue() == card2.getValue();
    }
}
