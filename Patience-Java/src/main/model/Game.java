package main.model;

import java.util.ArrayList;

public class Game {
    private ArrayList<Stack> stacks;
    private Deck deck;
    
    public Game() {
        stacks = new ArrayList<>();
        deck = new Deck();
    }
    
    public ArrayList<Stack> getStacks() {
        return stacks;
    }
    
    public Deck getDeck() {
        return deck;
    }
}
