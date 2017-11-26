package test.model;

import main.model.Card;
import main.model.GameTable;
import main.model.Stack;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class GameTableTest {

    private int expectedSize;
    private GameTable sut;

    @Before
    public void beforeEach() {
        sut = new GameTable();
    }

    @Test
    public void gameTableConstructorShouldCreateEmptyStackArrayList() {
        sut = new GameTable();
        expectedSize = 0;

        ArrayList<Stack> stacks = sut.getStacks();
        assertEquals(stacks.size(), expectedSize);
    }

    @Test
    public void addStackShouldIncreaseStackArrayListByOne() {
        expectedSize = 1;

        Card card = mock(Card.class);

        sut.addStack(card);

        assertEquals(expectedSize, sut.getStacks().size());
    }










}