package main.model;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        for (Color color : Color.values()) {
            for (Value value : Value.values()) {
                cards.add(new Card(color, value));
            }
        }
    }

    public ArrayList<Card> getCards() {
        ArrayList<Card> cardsCopy = new ArrayList<>();

        for (Card card : cards) {
            Card cardCopy = new Card(card.getColor(), card.getValue());
            cardsCopy.add(cardCopy);
        }

        return cardsCopy;
    }
}
