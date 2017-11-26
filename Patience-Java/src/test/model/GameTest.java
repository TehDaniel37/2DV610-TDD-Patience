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
    
    private Stack mockStack(Card top, Integer pos) {
        Stack stack = mock(Stack.class);
        
        if (pos != null) {
            when(stack.getPosition()).thenReturn(pos);
        }
        
        if (top != null) {
            when(stack.getTop()).thenReturn(top);
        }
    }
    
    @Before
    public void setup() {
        deck = mock(Deck.class);
        table = mock(GameTable.class);
        sut = new Game(deck, table);
    }
    
    @Test
    public void stacksMergeableShouldReturnTrueWhenCardsHaveSameColor() throws EmptyCardStackException {
        final int bottomStackPos = 0;
        final int topStackPos = 1; 

        Card mockCardBottom = mock(Card.class);
        Card mockCardTop = mock(Card.class);

        when(mockCardBottom.getColor()).thenReturn(Color.Hearts);
        when(mockCardTop.getColor()).thenReturn(Color.Hearts);
        when(mockCardBottom.getValue()).thenReturn(Value.Two);
        when(mockCardTop.getValue()).thenReturn(Value.Three);

        Stack mockStackBottom = mockStack(mockCardBottom, bottomStackPos);
        Stack mockStackTop = mockStack(mockCardTop, topStackPos);

        assertTrue(sut.stacksMergeable(mockStackBottom, mockStackTop));
    }
    
    @Test
    public void stacksMergeableShouldReturnFalseWhenBottomStackHasBiggerPos() {
        final int bottomStackPos = 1;
        final int topStackPos = 0;
        
        Stack mockStackBottom = mockStack(null, bottomStackPos);
        Stack mockStackTop = mockStack(null, topStackPos);
        
        assertFalse(sut.stacksMergeable(mockStackBottom, mockStackTop));
    }
}
