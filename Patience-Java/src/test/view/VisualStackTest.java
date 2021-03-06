package test.view;

import main.exception.EmptyCardStackException;
import main.model.Card;
import main.model.Color;
import main.model.Stack;
import main.model.Value;
import main.view.VisualStack;
import org.junit.*;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VisualStackTest extends ApplicationTest {

    private VisualStack sut;

    @Test
    public void constructorShouldCreateVisualCard() {
        Stack mockStack = mock(Stack.class);
        Card mockCard = mockCard(Color.Spades, Value.Six);

        try {
            when(mockStack.getTop()).thenReturn(mockCard);
            sut = new VisualStack(mockStack);
        } catch (EmptyCardStackException ignored) {
            fail();
        }

        assertNotNull(sut.getTopCard());
        assertEquals(mockCard, sut.getTopCard().getCard());
    }

    @Test
    public void updateShouldUpdateTopCard() {
        Card firstTopCard = mockCard(Color.Diamonds, Value.Four);
        Card topCardAfterUpdate = mockCard(Color.Clubs, Value.Jack);
        Stack mockStack = mock(Stack.class);

        try {
            when(mockStack.getTop()).thenReturn(firstTopCard);
            sut = new VisualStack(mockStack);
            when(mockStack.getTop()).thenReturn(topCardAfterUpdate);

            sut.update();
        } catch (EmptyCardStackException ex) {
            fail();
        }

        assertEquals(topCardAfterUpdate, sut.getTopCard().getCard());
    }

    @Test
    public void updateShouldRemoveCardWhenStackIsEmpty() {
        Stack mockStack = mock(Stack.class);
        Card mockCard = mockCard(Color.Spades, Value.Ace);

        try {
            when(mockStack.getTop()).thenReturn(mockCard);
            sut = new VisualStack(mockStack);
            when(mockStack.getTop()).thenThrow(new EmptyCardStackException());

            sut.update();
        } catch (EmptyCardStackException ex) {
            fail();
        }

        assertNull(sut.getTopCard());
    }

    private Card mockCard(Color color, Value value) {
        Card card = mock(Card.class);

        when(card.getColor()).thenReturn(color);
        when(card.getValue()).thenReturn(value);

        return card;
    }
}