package test.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.Random;

import main.model.Deck;
import main.model.Color;
import main.model.Value;
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
    
    @Test
    public void shuffleShouldRandomizeCardOrder() {
        final int seed = 123456789;
        Random random = new Random(seed);
        
        ArrayList<Card> expectedUnshuffled = new ArrayList<>();
        ArrayList<Card> expectedShuffled = new ArrayList<>();

        for (Color color : Color.values()) {
            for (Value value : Value.values()) {
                Card mockCard1 = mock(Card.class);
                Card mockCard2 = mock(Card.class);
                
                when(mockCard1.getColor()).thenReturn(color);
                when(mockCard1.getValue()).thenReturn(value);
                when(mockCard2.getColor()).thenReturn(color);
                when(mockCard2.getValue()).thenReturn(value);
                
                expectedUnshuffled.add(mockCard1);
                expectedShuffled.add(mockCard2);
            }
        }
        
        Collections.shuffle(expectedShuffled, random);
        
        Deck sut = new Deck();
        sut.setCards(expectedUnshuffled);
        sut.shuffle(seed);
        ArrayList<Card> actualShuffled = sut.getCards();
        
        assertEquals(actualShuffled, expectedShuffled);
    }
}
