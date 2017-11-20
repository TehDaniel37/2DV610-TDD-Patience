package main.exception;

/**
 * Created by Caroline Nilsson on 2017-11-20.
 */

public class EmptyCardStackException extends Exception {

    public EmptyCardStackException() {
        super("The Stack does not contain any Cards");
    }

    public EmptyCardStackException(String message)
    {
        super(message);
    }
}