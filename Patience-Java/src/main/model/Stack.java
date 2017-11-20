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

    public Card getTop() {
        int indexOfCard = stack.size()-1;
        return stack.get(indexOfCard);
    }


}
