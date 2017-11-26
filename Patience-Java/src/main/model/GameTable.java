package main.model;


import java.util.ArrayList;

public class GameTable {

    private ArrayList<Stack> stacks;

    public GameTable() {
        stacks = new ArrayList<Stack>();
    }

    public ArrayList<Stack> getStacks() {
        return stacks;
    }

    public void addStack(Card card) {

        Stack stack = new Stack(card);
        stacks.add(stack);
    }


}


