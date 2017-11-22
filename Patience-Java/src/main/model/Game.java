package main.model;

import java.util.ArrayList;

public class Game {
    private ArrayList<Stack> stacks;
    public Deck deck;
    
    public Game() {
        stacks = new ArrayList<>();
    }
    
    public ArrayList<Stack> getStacks() {
        return stacks;
    }
}
