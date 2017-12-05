package test.view;

import main.exception.EmptyCardStackException;
import main.model.Card;
import main.model.Color;
import main.model.Stack;
import main.model.Value;
import main.view.VisualStack;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VisualStackTest {

    @Test
    public void constructorShouldCreateVisualCard() {
        Stack mockStack = mock(Stack.class);
        Card mockCard = mock(Card.class);

        when(mockCard.getColor()).thenReturn(Color.Spades);
        when(mockCard.getValue()).thenReturn(Value.Six);

        VisualStack sut = null;

        try {
            when(mockStack.getTop()).thenReturn(mockCard);
            sut = new VisualStack(mockStack);
        } catch (EmptyCardStackException ignored) {
            fail();
        }

        assertNotNull(sut.topCard);
    }
}