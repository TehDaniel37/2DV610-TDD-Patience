package main.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

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
    
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    public void shuffle(int seed) {
        Random random = new Random(seed);
        Collections.shuffle(cards, random);
    }
}
