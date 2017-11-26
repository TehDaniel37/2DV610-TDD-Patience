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
    public void stacksMergeableShouldReturnTrueWhenCardsHaveSameColor() throws EmptyCardStackException {
        final int bottomStackPos = 0;
        final int topStackPos = 1; 

        Card mockCardBottom = mock(Card.class);
        Card mockCardTop = mock(Card.class);

        when(mockCardBottom.getColor()).thenReturn(Color.Hearts);
        when(mockCardTop.getColor()).thenReturn(Color.Hearts);
        when(mockCardBottom.getValue()).thenReturn(Value.Two);
        when(mockCardTop.getValue()).thenReturn(Value.Three);

        Stack mockStackBottom = mock(Stack.class);
        Stack mockStackTop = mock(Stack.class);

        when(mockStackBottom.getTop()).thenReturn(mockCardBottom);
        when(mockStackTop.getTop()).thenReturn(mockCardTop);
        when(mockStackTop.getPosition()).thenReturn(topStackPos);
        when(mockStackBottom.getPosition()).thenReturn(bottomStackPos);

        assertTrue(sut.stacksMergeable(mockStackBottom, mockStackTop));
    }
    
    @Test
    public void stacksMergeableShouldReturnFalseWhenBottomStackHasBiggerPos() {
        final int bottomStackPos = 1;
        final int topStackPos = 0;
        
        Stack mockStackBottom = mock(Stack.class);
        Stack mockStackTop = mock(Stack.class);
        
        when(mockStackBottom.getPosition()).thenReturn(bottomStackPos);
        when(mockStackTop.getPosition()).thenReturn(topStackPos);
        
        assertFalse(sut.stacksMergeable(mockStackBottom, mockStackTop));
    }
}
