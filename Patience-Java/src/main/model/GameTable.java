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

        Stack stack = new Stack(stacks.size(), card);
        stacks.add(stack);
        gameObserver.onStackAdded(stack);
    }

    public void mergeStacks(int positionBottomStack, int positionTopStack) throws IllegalAccessException {
        int upperBound = stacks.size();
        int lowerBound = 0;

        if (positionBottomStack >= upperBound || positionBottomStack < lowerBound
                || positionTopStack >= upperBound || positionTopStack < lowerBound) {
            throw new IllegalAccessException();
        }
        else {
            stacks.get(positionBottomStack).mergeStack(stacks.get(positionTopStack));
            gameObserver.onStacksMerged(positionBottomStack, positionTopStack);
        }

    }


}


