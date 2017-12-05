package main.view;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.model.Stack;

import java.util.ArrayList;

/**
 * Created by Caroline Nilsson on 2017-11-27.
 */
public class GameTableView implements GameObserver {

    private ArrayList<VisualStack> visualStacks;
    private GridPane stackGridPane;

    public GameTableView() {
        visualStacks = new ArrayList<>();
        stackGridPane = new GridPane();
    }

    public ArrayList<VisualStack> getVisualStacks() {
        return visualStacks;
    }

    public GridPane getStackGridPane() {
        return stackGridPane;
    }

    @Override
    public void onStackAdded(Stack stack) {

    }


    @Override
    public void onStacksMerged(int positionOfMerged, int positionOfDeleted) {

    }
}
