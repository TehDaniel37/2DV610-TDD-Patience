package test.model;

import main.model.GameTable;
import main.model.Stack;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTableTest {

    @Test
    public void gameTableConstructorShouldCreateEmptyStackArrayList() {
        GameTable gameTable = new GameTable();
        int expectedSize = 0;

        ArrayList<Stack> stacks = gameTable.getStacks();
        assertEquals(stacks.size(), expectedSize);
    }

}