package main.model;

import java.util.ArrayList;

public class Game {
    private GameTable gameTable;
    private Deck deck;
    
    public Game() {
        deck = new Deck();
        gameTable = new GameTable();
    }
    
    public ArrayList<Stack> getStacks() {
        return gameTable.getStacks();
    }
    
    public Deck getDeck() {
        return deck;
    }
    
    public GameTable getGameTable() {
        return gameTable;
    }

    public boolean stacksMergeable(Stack stack1, Stack stack2) {
        return true;
    }
}
