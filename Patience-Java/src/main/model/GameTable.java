package main.model;


import main.view.GameObserver;

import java.util.ArrayList;

public class GameTable {

    private GameObserver gameObserver;
    private ArrayList<Stack> stacks;

    public GameTable() {
        stacks = new ArrayList<Stack>();
    }

    public void setObserver(GameObserver observer) {
        gameObserver = observer;
    }

    public GameObserver getObserver() {
        return gameObserver;
    }

    public ArrayList<Stack> getStacks() {
        return stacks;
    }

    public void addStack(Card card) {

        Stack stack = new Stack(0, card);
        stacks.add(stack);
    }


}


