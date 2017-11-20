package test.model;

import main.model.Card;
import main.model.Color;
import main.model.Stack;
import main.model.Value;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StackTest {

    int expectedSize;


    @Test
    public void stackConstructorShouldCreateEmptyCardArrayList() {
        Stack stack = new Stack();
        expectedSize = 0;
        ArrayList<Card> stackOfCards = stack.getStack();

        assertEquals(stackOfCards.size(), expectedSize);
    }

    @Test
    public void addCardShouldIncreaseSizeOfStackByOne() {
        expectedSize = 1;
        Card card = mock(Card.class);
        Stack stack = new Stack();

        stack.addCard(card);


        assertEquals(stack.getStack().size(), expectedSize);
    }

    @Test
    public void getTopShouldReturnLatestCardAdded() {
        Card card = new Card(Color.Spades, Value.Ace);
        Stack stack = new Stack();
        stack.addCard(card);

        card = stack.getTop();

        assertEquals(card.getColor(), Color.Spades);
        assertEquals(card.getValue(), Value.Ace);

    }
}