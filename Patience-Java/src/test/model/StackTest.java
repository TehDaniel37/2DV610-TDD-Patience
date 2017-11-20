package test.model;

import main.model.Card;
import main.model.Stack;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

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


}