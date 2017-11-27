package main.model;


import main.exception.EmptyCardStackException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class Stack {

    private ArrayList<Card> stack;
    private int stackPosition;

    public Stack(int position) {
        stack = new ArrayList<Card>();
        stackPosition = position;
    }

    public Stack(int position, Card card) {
        stack = new ArrayList<Card>();
        stackPosition = position;
        stack.add(card);
    }

    public ArrayList<Card> getStack() {
        return stack;
    }

    public void addCard(Card card) {
        stack.add(card);
    }

    public Card getTop() throws EmptyCardStackException {
        int indexOfCard = stack.size()-1;
        if (indexOfCard < 0) {
            throw new EmptyCardStackException();
        }
        else {
            return stack.get(indexOfCard);
        }
    }

    public int getPosition() {
        return stackPosition;
    }

    public void mergeStack(Stack stack) {
        for (Card card : stack.getStack()) {
            this.addCard(card);
        }
        stack.getStack().clear();
    }
}
