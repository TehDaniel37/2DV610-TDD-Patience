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

        assertEquals(card.color, expectedColor);
        assertEquals(card.value, expectedValue);
    }
}
