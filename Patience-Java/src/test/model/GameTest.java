package test.model;

import main.exception.EmptyCardStackException;
import main.model.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.invoke.empty.Empty;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    
    private Game sut;
    
    @Before
    public void setup() {
        sut = new Game();
    }
    
    @Test
    public void constructorShouldCreateEmptyStackList() {
        assertNotNull(sut.getStacks());
        assertEquals(sut.getStacks().size(), 0);
    }
    
    @Test
    public void constructorShouldCreateDeck() {
        assertNotNull(sut.getDeck());
    }
    
    @Test
    public void constructorShouldCreateGameTable() {
        assertNotNull(sut.getGameTable());
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
        when(mockStackTop.getPosition()).thenReturn(bottomStackPos);
        when(mockStackBottom.getPosition()).thenReturn(topStackPos);

        assertTrue(sut.stacksMergeable(mockStackBottom, mockStackTop));
    }
}
