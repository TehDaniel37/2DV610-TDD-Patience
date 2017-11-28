package main.view;

import main.model.Stack;

/**
 * Created by Caroline Nilsson on 2017-11-27.
 */
public interface GameObserver {

    void onStackAdded(Stack stack);

    void onStacksMerged(int positionOfMerged, int positionOfDeleted);
}
