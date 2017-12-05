package main.view;

import main.exception.EmptyCardStackException;
import main.model.Stack;

/**
 * Created by Caroline Nilsson on 2017-11-27.
 */
public class VisualStack {

    public VisualCard topCard;

    public VisualStack(Stack stack) throws EmptyCardStackException {
        topCard = new VisualCard(stack.getTop());
    }
}
