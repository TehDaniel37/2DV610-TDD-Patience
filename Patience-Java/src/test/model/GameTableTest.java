package test.model;

import main.exception.EmptyCardStackException;
import main.model.Card;
import main.model.Color;
import main.model.GameTable;
import main.model.Stack;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void mergeStacksShouldCombineTwoStacks() {

        Stack stackBottom = new Stack();
        Stack stackTop = new Stack();

        Card card = mock(Card.class);

        stackBottom.addCard(card);
        stackBottom.addCard(card);
        stackTop.addCard(card);
        stackTop.addCard(card);

        expectedSize = 4;

        sut.mergeStacks(stackBottom, stackTop);

        assertEquals(expectedSize, stackBottom.getStack().size());
    }

    @Test
    public void topCardAfterMergeShouldBeLatestAddedInTopStack() throws EmptyCardStackException {
        Stack stackBottom = new Stack();
        Stack stackTop = new Stack();

        Card card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Hearts);
        stackBottom.addCard(card);
        card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Spades);
        stackBottom.addCard(card);
        card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Diamonds);
        stackTop.addCard(card);
        card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Clubs);
        stackTop.addCard(card);

        Color expectedColor = Color.Clubs;

        sut.mergeStacks(stackBottom, stackTop);

        assertEquals(expectedColor, stackBottom.getTop().getColor());
    }

    @Test
    public void topStackShouldBeEmptyAfterMerge() {
        Stack stackBottom = new Stack();
        Stack stackTop = new Stack();

        Card card = mock(Card.class);

        stackBottom.addCard(card);
        stackBottom.addCard(card);
        stackTop.addCard(card);
        stackTop.addCard(card);

        expectedSize = 0;

        sut.mergeStacks(stackBottom, stackTop);

        assertEquals(expectedSize, stackTop.getStack().size());
    }




}