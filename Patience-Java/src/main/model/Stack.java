package main.model;


import java.util.ArrayList;

public class Stack {

    private ArrayList<Card> stack;

    public Stack() {
        stack = new ArrayList<Card>();
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

    public static class EmptyCardStackException extends Exception {

        public EmptyCardStackException() {
            super("The Stack does not contain any Cards");
        }

        public EmptyCardStackException(String message)
        {
            super(message);
        }
    }


}
