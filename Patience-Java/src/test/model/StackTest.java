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

public class StackTest {


    @Test
    public void stackConstructorShouldCreateEmptyCardArrayList() {
        Stack stack = new Stack();
        int expectedSize = 0;
        ArrayList<Card> stackOfCards = stack.getStack();

        assertEquals(stackOfCards.size(), expectedSize);
    }
}