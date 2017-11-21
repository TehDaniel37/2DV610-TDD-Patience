package test.model;

import main.model.Card;
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

public class GameTableTest {

    @Test
    public void gameTableConstructorShouldCreateEmptyStackArrayList() {
        GameTable gameTable = new GameTable();
        int expectedSize = 0;

        ArrayList<Stack> stacks = gameTable.getStacks();
        assertEquals(stacks.size(), expectedSize);
    }

    @Test
    public void addStackShouldIncreaseStackArrayListByOne() {
        GameTable sut = new GameTable();
        int expectedSize = 1;

        Card card = mock(Card.class);

        sut.addStack(card);

        assertEquals(expectedSize, sut.getStacks().size());
    }

}