package test.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashSet;

import main.Deck;
import main.Card;

public class DeckTest {

    @Test
    public void constructorShouldCreate52UniqueCards() {
        final int expectedSize = 52;

        Deck deck = new Deck();
        HashSet<Card> setOfCards = new HashSet<>(deck.cards);       // Get only unique cards from Deck
        
        assertEquals(deck.cards.size(), expectedSize);
        assertEquals(setOfCards.size(), expectedSize);
    }
}