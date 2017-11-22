package main.model;

import java.util.ArrayList;

public class Game {
    private ArrayList<Stack> stacks;
    
    public Game() {
        stacks = new ArrayList<>();
    }
    
    public ArrayList<Stack> getStacks() {
        return stacks;
    }
}
