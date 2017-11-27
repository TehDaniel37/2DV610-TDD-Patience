package main.exception;

/**
 * Created by Caroline Nilsson on 2017-11-27.
 */
public class EmptyDeckException extends Exception {

    public EmptyDeckException() {
        super("The Deck doesn't contain any cards");
    }
}
