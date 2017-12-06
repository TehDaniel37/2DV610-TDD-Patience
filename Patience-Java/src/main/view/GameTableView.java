package main.view;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.model.Stack;

import java.util.ArrayList;

/**
 * Created by Caroline Nilsson on 2017-11-27.
 */
public class GameTableView extends ScrollPane implements GameObserver {

    private final int MAX_ROWS = 5;

    private ArrayList<VisualStack> visualStacks;
    private GridPane stackGridPane;

    public GameTableView() {
        visualStacks = new ArrayList<>();
        stackGridPane = new GridPane();

        this.setContent(stackGridPane);
    }

    public ArrayList<VisualStack> getVisualStacks() {
        return visualStacks;
    }

    public GridPane getStackGridPane() {
        return stackGridPane;
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

    }

    public void updateGridPane() {
        stackGridPane.getChildren().clear();
        int indexRow = 0;
        int indexColumn = 0;

        for (int i = 0; i < visualStacks.size() ; i++) {
            VisualStack vs = visualStacks.get(i);
            if (indexColumn == MAX_ROWS) {
                indexColumn = 0;
                indexRow++;
            }
            stackGridPane.add(vs, indexColumn, indexRow);
        }
    }
}
