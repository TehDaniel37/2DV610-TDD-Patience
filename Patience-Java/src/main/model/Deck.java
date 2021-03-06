package main.model;

import main.exception.EmptyDeckException;

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
        return cards;
    }
    
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    public void shuffle(int seed) {
        Random random = new Random(seed);
        Collections.shuffle(cards, random);
    }

    public Card deal() throws EmptyDeckException{
        if (cards.size() == 0) {
            throw new EmptyDeckException();
        }
        else {
            Card card = cards.get(0);
            cards.remove(card);
            return card;
        }

    }
}
