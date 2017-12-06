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
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VisualStackTest {

    private VisualStack sut;

    @Test
    public void constructorShouldCreateVisualCard() {
        Stack mockStack = mock(Stack.class);
        Card mockCard = mock(Card.class);

        when(mockCard.getColor()).thenReturn(Color.Spades);
        when(mockCard.getValue()).thenReturn(Value.Six);

        try {
            when(mockStack.getTop()).thenReturn(mockCard);
            sut = new VisualStack(mockStack);
        } catch (EmptyCardStackException ignored) {
            fail();
        }

        assertNotNull(sut.getTopCard());
    }

    @Test
    public void updateShouldUpdateTopCard() {
        Card firstTopCard = mock(Card.class);
        Card topCardAfterUpdate = mock(Card.class);
        Stack mockStack = mock(Stack.class);

        when(firstTopCard.getColor()).thenReturn(Color.Diamonds);
        when(firstTopCard.getValue()).thenReturn(Value.Four);
        when(topCardAfterUpdate.getColor()).thenReturn(Color.Clubs);
        when(topCardAfterUpdate.getValue()).thenReturn(Value.Jack);

        try {
            when(mockStack.getTop()).thenReturn(firstTopCard);
            sut = new VisualStack(mockStack);
            when(mockStack.getTop()).thenReturn(topCardAfterUpdate);
        } catch (EmptyCardStackException ex) {
            fail();
        }

        sut.update();

        assertEquals(topCardAfterUpdate, sut.getTopCard().getCard());
    }
}