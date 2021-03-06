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
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTableViewTest extends ApplicationTest {

    private GameTableView sut;
    private Stack stack;
    private VisualStack visualStack;

    @Before
    public void beforeEach() throws EmptyCardStackException{
        sut = new GameTableView();
        mockStack();
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
    public void onStackAddedShouldAddVisualStackToVisualStacks() {
        sut.onStackAdded(stack);

        int expectedSize = 1;
        assertEquals(expectedSize, sut.getVisualStacks().size());
    }

    @Test
    public void onStackAddedShouldUpdatePane() {
        sut.onStackAdded(stack);

        assertNotNull(getNode(0,0, sut.getStackGridPane()));

    }

    @Test
    public void onStacksMergedShouldCallUpdateVisualStack() {
        visualStack = mockVisualStack();
        sut.onStacksMerged(0, 1);

        verify(visualStack).update();

    }

    @Test
    public void onStacksMergedShouldDeleteVisualStackRepresentingRemovedStack() {
        visualStack = mockVisualStack();
        sut.onStacksMerged(0, 1);
        int expectedSize = 1;

        assertEquals(expectedSize, sut.getVisualStacks().size());
    }

    private VisualStack mockVisualStack() {
        VisualStack visualStack = mock(VisualStack.class);
        ArrayList<VisualStack> stacks = sut.getVisualStacks();
        stacks.add(visualStack);
        stacks.add(visualStack);

        return visualStack;
    }

    private Stack mockStack() throws EmptyCardStackException {
        stack = mock(Stack.class);
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