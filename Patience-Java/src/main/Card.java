package main;

import java.util.Objects;

public class Card {

    private Color color;
    private Value value;

    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Card)) {
            return false;
        }

        Card otherCard = (Card)other;

        return Objects.equals(this.getColor(), otherCard.getColor())
            && Objects.equals(this.getValue(), otherCard.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getColor(), this.getValue());
    }
}
