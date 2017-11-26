package test.model;

import main.exception.EmptyCardStackException;
import main.model.Card;
import main.model.Color;
import main.model.Stack;
import main.model.Value;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StackTest {

    private int expectedSize;
    private Card card;
    private Stack sut;


    @Before
    public void beforeEach() {
        sut = new Stack();
    }


    @Test
    public void stackConstructorShouldCreateEmptyCardArrayList() {
        sut = new Stack();
        expectedSize = 0;

        assertEquals(sut.getStack().size(), expectedSize);
    }

    @Test
    public void stackConstructorShouldAddCardToCardArrayList() {
        card = mock(Card.class);
        sut = new Stack(card);

        expectedSize = 1;

        assertEquals(expectedSize, sut.getStack().size());
    }

    @Test
    public void addCardShouldIncreaseSizeOfStackByOne() {
        expectedSize = 1;
        card = mock(Card.class);
        sut = new Stack();

        sut.addCard(card);


        assertEquals(sut.getStack().size(), expectedSize);
    }

    @Test
    public void getTopShouldReturnLatestCardAdded() {
        Color expectedColor = Color.Spades;
        Value expectedValue = Value.Ace;

        card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Spades);
        when(card.getValue()).thenReturn(Value.Ace);

        sut = new Stack();
        sut.addCard(card);

        try {
            card = sut.getTop();
        }
        catch (EmptyCardStackException ex) {
            fail();
        }

        assertEquals(card.getColor(), expectedColor);
        assertEquals(card.getValue(), expectedValue);

    }

    @Test (expected = EmptyCardStackException.class)
    public void getTopShouldThrowEmptyCardStackException() throws EmptyCardStackException {

        sut.getTop();


    }

    @Test
    public void mergeStacksShouldCombineTwoStacks() {

        Stack stackTop = new Stack();

        Card card = mock(Card.class);

        sut.addCard(card);
        sut.addCard(card);
        stackTop.addCard(card);
        stackTop.addCard(card);

        expectedSize = 4;

        sut.mergeStack(stackTop);

        assertEquals(expectedSize, sut.getStack().size());
    }

    @Test
    public void topCardAfterMergeShouldBeLatestAddedInTopStack() throws EmptyCardStackException {

        Stack stackTop = initializeCardsForStacks();

        Color expectedColor = Color.Clubs;

        sut.mergeStack(stackTop);

        assertEquals(expectedColor, sut.getTop().getColor());
    }

    @Test
    public void topStackShouldBeEmptyAfterMerge() throws EmptyCardStackException {

        Stack stackTop = initializeCardsForStacks();

        expectedSize = 0;

        sut.mergeStack(stackTop);

        assertEquals(expectedSize, stackTop.getStack().size());
    }

    private Stack initializeCardsForStacks() {
        Stack topStack = new Stack();

        Card card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Hearts);
        sut.addCard(card);
        card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Spades);
        sut.addCard(card);
        card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Diamonds);
        topStack.addCard(card);
        card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Clubs);
        topStack.addCard(card);

        return topStack;
    }



}