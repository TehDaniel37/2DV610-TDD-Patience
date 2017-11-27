package test.model;

import main.exception.EmptyCardStackException;
import main.model.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    
    private Deck deck;
    private GameTable table;
    private Game sut;
    
    @Before
    public void setup() {
        deck = mock(Deck.class);
        table = mock(GameTable.class);
        sut = new Game(deck, table);
    }
    
    @Test
    public void stacksMergeableShouldReturnTrueWhenCardsHaveSameColor() {
        Card mockCardBottom = mockCard(Color.Hearts, Value.Two);
        Card mockCardTop = mockCard(Color.Hearts, Value.Three);
        Stack mockStackBottom = mockStack(mockCardBottom, 0);
        Stack mockStackTop = mockStack(mockCardTop, 1);

        assertTrue(sut.stacksMergeable(mockStackBottom, mockStackTop));
    }
    
    @Test
    public void stacksMergeableShouldReturnTrueWhenCardsHaveSameValue() {
        Card mockCardBottom = mockCard(Color.Spades, Value.King);
        Card mockCardTop = mockCard(Color.Diamonds, Value.King);
        Stack mockStackBottom = mockStack(mockCardBottom, 0);
        Stack mockStackTop = mockStack(mockCardTop, 1);

        assertTrue(sut.stacksMergeable(mockStackBottom, mockStackTop));
    }
    
    @Test
    public void stacksMergeableShouldReturnFalseWhenBottomStackHasBiggerPos() {
        Stack mockStackBottom = mockStack(null, 1);
        Stack mockStackTop = mockStack(null, 0);
        
        assertFalse(sut.stacksMergeable(mockStackBottom, mockStackTop));
    }
    
    @Test
    public void stacksMergeableShouldReturnTrueWhenBottomStackIsThreePositionsFromTopStack() {
        Stack mockStackBottom = mockStack(mockCard(Color.Spades, Value.Ace), 0);
        Stack mockStackTop = mockStack(mockCard(Color.Spades, Value.King), 3);
        
        assertTrue(sut.stacksMergeable(mockStackBottom, mockStackTop));
    }
    
    private Stack mockStack(Card top, Integer pos) {
        Stack stack = mock(Stack.class);
        
        if (pos != null) {
            when(stack.getPosition()).thenReturn(pos);
        }
        
        if (top != null) {
            try {
                when(stack.getTop()).thenReturn(top);
            } catch (EmptyCardStackException ex) { }
        }
        
        return stack;
    }
    
    private Card mockCard(Color color, Value value) {
        Card card = mock(Card.class);
        
        when(card.getColor()).thenReturn(color);
        when(card.getValue()).thenReturn(value);
        
        return card;
    }
}
