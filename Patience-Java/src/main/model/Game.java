package main.model;

import main.exception.EmptyCardStackException;
import main.exception.EmptyDeckException;


public class Game {
    private GameTable gameTable;
    private Deck deck;
    
    public Game(Deck deck, GameTable table) {
        this.deck = deck;
        this.gameTable = table;
    }

    public boolean stacksMergeable(Stack mergeInto, Stack mergeFrom) {
        int positionDifference = mergeFrom.getPosition() - mergeInto.getPosition();

        if (!(positionDifference == 1 || positionDifference == 3)) {
            return false;
        }

        Card card1;
        Card card2;

        try {
            card1 = mergeInto.getTop();
            card2 = mergeFrom.getTop();
        } catch (EmptyCardStackException ex) {
            return false;
        }

        return card1.getColor() == card2.getColor() || card1.getValue() == card2.getValue();
    }

    public boolean dealNewCard() {
        try {
            Card card = deck.deal();
            gameTable.addStack(card);
            return true;
        }
        catch (EmptyDeckException ex) {
            return false;
        }
    }

    public boolean setUpGameStart() throws EmptyDeckException {
        Card card = deck.deal();
        gameTable.addStack(card);
        card = deck.deal();
        gameTable.addStack(card);
        return true;
    }
}
