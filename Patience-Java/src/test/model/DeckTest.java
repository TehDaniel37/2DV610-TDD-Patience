package test.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import main.Deck;
import main.Card;

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