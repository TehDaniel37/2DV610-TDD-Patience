package main.model;

import java.util.ArrayList;

public class Game {
    public GameTable gameTable;
    
    private ArrayList<Stack> stacks;
    private Deck deck;
    
    public Game() {
        stacks = new ArrayList<>();
        deck = new Deck();
        gameTable = new GameTable();
    }
    
    public ArrayList<Stack> getStacks() {
        return stacks;
    }
    
    public Deck getDeck() {
        return deck;
    }
}
