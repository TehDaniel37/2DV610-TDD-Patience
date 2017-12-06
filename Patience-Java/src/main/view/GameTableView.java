package main.view;

import javafx.application.Application;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.model.Stack;

import java.util.ArrayList;

/**
 * Created by Caroline Nilsson on 2017-11-27.
 */
public class GameTableView extends ScrollPane implements GameObserver {

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
        }
        catch (Exception e) {

        }
    }


    @Override
    public void onStacksMerged(int positionOfMerged, int positionOfDeleted) {

    }
}
