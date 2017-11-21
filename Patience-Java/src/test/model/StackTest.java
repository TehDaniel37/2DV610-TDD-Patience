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
        Card card = mock(Card.class);
        sut = new Stack(card);

        expectedSize = 1;

        assertEquals(expectedSize, sut.getStack().size());
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
        Color expectedColor = Color.Spades;
        Value expectedValue = Value.Ace;

        Card mockCard = mock(Card.class);
        when(mockCard.getColor()).thenReturn(Color.Spades);
        when(mockCard.getValue()).thenReturn(Value.Ace);

        sut = new Stack();
        sut.addCard(mockCard);

        try {
            mockCard = sut.getTop();
        }
        catch (EmptyCardStackException ex) {
            fail();
        }

        assertEquals(mockCard.getColor(), expectedColor);
        assertEquals(mockCard.getValue(), expectedValue);

    }

    @Test (expected = EmptyCardStackException.class)
    public void getTopShouldThrowEmptyCardStackException() throws EmptyCardStackException {

        sut.getTop();


    }


}