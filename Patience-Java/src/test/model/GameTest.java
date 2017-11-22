package test.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.model.Game;
import main.model.Stack;

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
}
