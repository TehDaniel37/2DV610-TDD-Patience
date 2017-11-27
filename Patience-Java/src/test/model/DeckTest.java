package test.model;

import main.exception.EmptyDeckException;
import org.junit.Before;
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

    Deck sut;

    @Before
    public void beforeEach() {
        sut = new Deck();
    }

    @Test
    public void constructorShouldCreate52UniqueCards() {
        final int expectedSize = 52;

        Deck sut = new Deck();

        ArrayList<Card> actualCards = sut.getCards();
        HashSet<Card> setOfCards = new HashSet<>(actualCards);       // Get only unique cards from Deck
        
        assertEquals(actualCards.size(), expectedSize);
        assertEquals(setOfCards.size(), expectedSize);
    }
    
    @Test
    public void shuffleShouldRandomizeCardOrder() {
        final int seed = 123456789;
        
        ArrayList<Card> unshuffled = new ArrayList<>();
        ArrayList<Card> expected = new ArrayList<>();

        for (Color color : Color.values()) {
            for (Value value : Value.values()) {
                Card mockCard1 = mock(Card.class);
                Card mockCard2 = mock(Card.class);
                
                when(mockCard1.getColor()).thenReturn(color);
                when(mockCard1.getValue()).thenReturn(value);
                when(mockCard2.getColor()).thenReturn(color);
                when(mockCard2.getValue()).thenReturn(value);
                
                unshuffled.add(mockCard1);
                expected.add(mockCard2);
            }
        }

        Collections.shuffle(expected, new Random(seed));
        

        sut.setCards(unshuffled);
        sut.shuffle(seed);
        ArrayList<Card> actual = sut.getCards();
        
        assertEquals(actual.size(), expected.size());
        
        for (int i = 0; i < expected.size(); i++) {
            Card actualCard = actual.get(i);
            Card expectedCard = expected.get(i);
            
            assertEquals(actualCard.getColor(), expectedCard.getColor());
            assertEquals(actualCard.getValue(), expectedCard.getValue());
        }
    }

    @Test
    public void dealShouldReturnACardAndRemoveItFromDeck() throws EmptyDeckException {
        Card card = sut.deal();

        int expectedSize = 51;

        assertNotNull(card);
        assertEquals(expectedSize, sut.getCards().size());
    }

    @Test (expected = EmptyDeckException.class)
    public void dealShouldThrowEmptyDeckExceptionIfEmptyDeck() throws EmptyDeckException {
        sut.getCards().clear();

        sut.deal();
    }
}
