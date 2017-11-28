package test.model;

import main.model.Card;
import main.model.GameTable;
import main.model.Stack;
import main.view.GameObserver;
import main.view.GameTableView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTableTest {

    private int expectedSize;
    private GameTable sut;
    private GameTableView mockGameTableView;
    private Card mockCard;

    @Before
    public void beforeEach() {
        sut = new GameTable();
        mockGameTableView = mock(GameTableView.class);
        sut.setObserver(mockGameTableView);
        mockCard = mock(Card.class);
    }

    @Test
    public void gameTableConstructorShouldCreateEmptyStackArrayList() {
        sut = new GameTable();
        expectedSize = 0;

        ArrayList<Stack> stacks = sut.getStacks();
        assertEquals(stacks.size(), expectedSize);
    }

    @Test
    public void setObserverShouldAddObserver() {
        GameObserver gameObserver = mock(GameObserver.class);
        sut.setObserver(gameObserver);

        assertNotNull(sut.getObserver());
    }

    @Test
    public void addStackShouldIncreaseStackArrayListByOne() {
        expectedSize = 1;

        sut.addStack(mockCard);

        assertEquals(expectedSize, sut.getStacks().size());
    }

    @Test
    public void addStackShouldCallObserverOnStackAdded() {

        sut.addStack(mockCard);

        verify(mockGameTableView).onStackAdded(sut.getStacks().get(0));
    }

    @Test
    public void mergeStacksShouldCallOnStacksMerged() {
        sut.addStack(mockCard);
        sut.addStack(mockCard);

        sut.mergeStacks(0, 1);
        verify(mockGameTableView).onStacksMerged(0,1);

    }

    @Test
    public void mergeStacksShouldCallMergeMethodInStack() {
        sut.addStack(mockCard);
        sut.addStack(mockCard);

        sut.mergeStacks(0,1);
        verify(sut.getStacks().get(0)).mergeStack(sut.getStacks().get(1));
    }












}