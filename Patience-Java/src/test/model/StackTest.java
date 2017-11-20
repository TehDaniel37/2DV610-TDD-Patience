package test.model;

import main.model.Card;
import main.model.Color;
import main.model.Stack;
import main.model.Value;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class StackTest {

    private int expectedSize;
    private Stack sut;

    @Before
    public void beforeEach() {
        sut = new Stack();
    }


    @Test
    public void stackConstructorShouldCreateEmptyCardArrayList() {
        Stack sut = new Stack();
        expectedSize = 0;

        assertEquals(sut.getStack().size(), expectedSize);
    }

    @Test
    public void addCardShouldIncreaseSizeOfStackByOne() {
        expectedSize = 1;
        Card card = mock(Card.class);
        sut = new Stack();

        sut.addCard(card);


        assertEquals(sut.getStack().size(), expectedSize);
    }

    @Test
    public void getTopShouldReturnLatestCardAdded() {
        Card card = new Card(Color.Spades, Value.Ace);
        sut = new Stack();
        sut.addCard(card);

        card = sut.getTop();

        assertEquals(card.getColor(), Color.Spades);
        assertEquals(card.getValue(), Value.Ace);

    }

    @Test (expected = Stack.EmptyCardStackException.class)
    public void getTopShouldThrowEmptyCardStackException() {
        sut.getTop();
    }


}