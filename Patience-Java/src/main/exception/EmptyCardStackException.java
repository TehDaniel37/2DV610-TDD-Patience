package main.exception;

/**
 *
 */

public class EmptyCardStackException extends Exception {

    public EmptyCardStackException() {
        super("The Stack does not contain any Cards");
    }


}