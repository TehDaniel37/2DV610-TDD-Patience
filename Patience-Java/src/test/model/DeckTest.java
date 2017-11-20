package test.model;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import main.model.Deck;
import main.model.Card;

public class DeckTest {

    @Test
    public void constructorShouldCreate52UniqueCards() {
        final int expectedSize = 52;

        Deck deck = new Deck();

        ArrayList<Card> actualCards = deck.getCards();
        HashSet<Card> setOfCards = new HashSet<>(actualCards);       // Get only unique cards from Deck
        
        assertEquals(actualCards.size(), expectedSize);
        assertEquals(setOfCards.size(), expectedSize);
    }
}