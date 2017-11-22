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
    
    @Test
    public void constructorShouldCreateEmptyStackList() {
        Game sut = new Game();
        
        assertNotNull(sut.getStacks());
        assertEquals(sut.getStacks().size(), 0);
    }
    
    @Test
    public void constructorShouldCreateDeck() {
        Game sut = new Game();
        
        assertNotNull(sut.deck);
    }
}
