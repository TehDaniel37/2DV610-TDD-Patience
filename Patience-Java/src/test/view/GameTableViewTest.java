package test.view;


import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.exception.EmptyCardStackException;
import main.model.Card;
import main.model.Color;
import main.model.Stack;
import main.model.Value;
import main.view.GameTableView;
import main.view.VisualStack;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTableViewTest extends ApplicationTest {

    private GameTableView sut;

    @Before
    public void beforeEach() {
        sut = new GameTableView();
    }

    @Override
    public void start(Stage stage) throws Exception {

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
    public void constructorShouldCreateGame() {
        assertNotNull(sut.getCurrentGame());
    }

    @Test
    public void onStackAddedShouldAddVisualStackToVisualStacks() throws EmptyCardStackException {
        Stack stack = initializeMockStack();
        sut.onStackAdded(stack);

        int expectedSize = 1;

        assertEquals(expectedSize, sut.getVisualStacks().size());
    }

    @Test
    public void onStackAddedShouldUpdatePane() throws EmptyCardStackException {
        Stack stack = initializeMockStack();
        sut.onStackAdded(stack);

        assertNotNull(getNode(0,0, sut.getStackGridPane()));

    }

    @Test
    public void onStacksMergedShouldCallUpdateVisualStack() {
        VisualStack visualStack = mock(VisualStack.class);
        sut.onStacksMerged(0, 1);

        verify(visualStack).update();

    }

    private Stack initializeMockStack() throws EmptyCardStackException {
        Stack stack = mock(Stack.class);
        Card card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.Hearts);
        when(card.getValue()).thenReturn(Value.Ace);
        when(stack.getTop()).thenReturn(card);

        return stack;
    }

    private Node getNode (int row, int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();

        for (Node node : children) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }
}