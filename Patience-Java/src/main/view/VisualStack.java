package main.view;

import javafx.scene.control.Button;
import main.exception.EmptyCardStackException;
import main.model.Stack;

/**
 * Created by Caroline Nilsson on 2017-11-27.
 */
public class VisualStack extends Button{

    private VisualCard topCard;
    private Stack stack;

    public VisualStack(Stack stack) throws EmptyCardStackException {
        this.stack = stack;
        topCard = new VisualCard(stack.getTop());
    }

    public VisualCard getTopCard() {
        return topCard;
    }

    public void update() {
        try {
            topCard = new VisualCard(stack.getTop());
        } catch(EmptyCardStackException ex) {
            topCard = null;
        }
    }
}
