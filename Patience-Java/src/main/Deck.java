package main;

import java.util.ArrayList;

public class Deck {

    public ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        for (Color color : Color.values()) {
            for (Value value : Value.values()) {
                cards.add(new Card(color, value));
            }
        }
    }
}
