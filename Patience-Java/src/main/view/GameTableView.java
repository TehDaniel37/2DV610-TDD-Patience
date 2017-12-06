package main.view;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import main.model.Deck;
import main.model.Game;
import main.model.GameTable;
import main.model.Stack;

import java.util.ArrayList;

/**
 * Created by Caroline Nilsson on 2017-11-27.
 */
public class GameTableView extends ScrollPane implements GameObserver {

    private final int MAX_COLUMNS = 5;

    private ArrayList<VisualStack> visualStacks;
    private final GridPane stackGridPane;
    private Game currentGame;

    public GameTableView() {
        visualStacks = new ArrayList<>();
        stackGridPane = new GridPane();
        currentGame = new Game(new Deck(), new GameTable());

        this.setContent(stackGridPane);
    }

    public ArrayList<VisualStack> getVisualStacks() {
        return visualStacks;
    }

    public GridPane getStackGridPane() {
        return stackGridPane;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    @Override
    public void onStackAdded(Stack stack) {
        try {
            VisualStack newStack = new VisualStack(stack);
            visualStacks.add(newStack);
            updateGridPane();
        }
        catch (Exception e) {

        }
    }


    @Override
    public void onStacksMerged(int positionOfMerged, int positionOfDeleted) {
        visualStacks.get(positionOfMerged).update();
        visualStacks.remove(positionOfDeleted);
    }

    public void updateGridPane() {
        stackGridPane.getChildren().clear();
        int indexRow = 0;
        int indexColumn = 0;

        for (int i = 0; i < visualStacks.size() ; i++) {
            VisualStack vs = visualStacks.get(i);
            if (indexColumn == MAX_COLUMNS) {
                indexColumn = 0;
                indexRow++;
            }
            stackGridPane.add(vs, indexColumn, indexRow);
        }
    }


}
