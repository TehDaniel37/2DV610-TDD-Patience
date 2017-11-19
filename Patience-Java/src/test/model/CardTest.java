package test.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.Card;
import main.Color;
import main.Value;

public class CardTest {

    @Test
    public void constructorShouldSetColorAndValue() {
        Color expectedColor = Color.Hearts;
        Value expectedValue = Value.Two;

        Card card = new Card(expectedColor, expectedValue);

        assertEquals(card.getColor(), expectedColor);
        assertEquals(card.getValue(), expectedValue);
    }

    @Test
    public void equalsShouldReturnTrue() {
        Card card1 = new Card(Color.Spades, Value.Ace);
        Card card2 = new Card(Color.Spades, Value.Ace);

        assertTrue(card1.equals(card2));
    }
}
