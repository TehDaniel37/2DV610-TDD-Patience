package main.model;


import main.exception.EmptyCardStackException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class Stack {

    private ArrayList<Card> stack;

    public Stack() {
        stack = new ArrayList<Card>();
    }

    public Stack(Card card) {
        stack = new ArrayList<Card>();
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
        throw new NotImplementedException();
    }

    public void mergeStack(Stack stack) {
        for (Card card : stack.getStack()) {
            this.addCard(card);
        }

        stack.getStack().clear();
    }
}
