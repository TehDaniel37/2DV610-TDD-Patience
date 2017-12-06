package test.view;


import javafx.scene.Scene;
import javafx.stage.Stage;
import main.exception.EmptyCardStackException;
import main.exception.EmptyDeckException;
import main.model.Card;
import main.model.Color;
import main.model.Stack;
import main.model.Value;
import main.view.GameTableView;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTableViewTest extends ApplicationTest {

    private GameTableView sut;

    @Before
    public void beforeEach() {
        sut = new GameTableView();
    }


    @Test
    public void constructorShouldCreateVisualStackArrayList() {
        assertNotNull(sut.getVisualStacks());
    }

    @Test
    public void constructorShouldCreateGridPane() {
        assertNotNull(sut.getStackGridPane());
    }

    @Test
    public void constructorShouldAddGridPaneToGameTableView() {
        assertNotNull(sut.getContent());
    }

    @Test
    public void onStackAddedShouldAddVisualStackToVisualStacks() throws EmptyCardStackException {
        Stack stack = mock(Stack.class);
        Card card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Hearts);
        when(card.getValue()).thenReturn(Value.Ace);
        when(stack.getTop()).thenReturn(card);

        sut.onStackAdded(stack);

        int expectedSize = 1;

        assertEquals(expectedSize, sut.getVisualStacks().size());
    }


    @Override
    public void start(Stage stage) throws Exception {

    }
}