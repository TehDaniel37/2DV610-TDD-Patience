package main.view;

import java.io.File;
import java.io.IOException;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;

import main.model.Card;
import main.model.Color;
import main.model.Value;

/**
 * Created by Caroline Nilsson on 2017-11-27.
 */
public class VisualCard {

    private Image image;

    public VisualCard(Card card) throws IOException {
        image = VisualCard.CardImageLoader.getImage(card.getColor(), card.getValue());
    }

    public Image getImage() {
        return image;
    }
    
    private static class CardImageLoader {
    
    private static final String CARDS_SHEET_PATH = "cards.png";
    private static final int SHEET_OFFSET_X = 38;
    private static final int SHEET_OFFSET_Y = 29;
    private static final int SHEET_CARD_DISTANCE_X = 28;
    private static final int SHEET_CARD_DISTANCE_Y = 28;
    private static final int SHEET_CARD_WIDTH = 362;
    private static final int SHEET_CARD_HEIGHT = 542;

    private static BufferedImage cardSheet;
    
    public static Image getImage(Color color, Value value) throws IOException {
        if (cardSheet == null) {
            cardSheet = ImageIO.read(VisualCard.CardImageLoader.class.getClassLoader().getResource(CARDS_SHEET_PATH));
        }
        
        int xIndex = value.ordinal();
        int yIndex = color.ordinal();
        int xPos = SHEET_OFFSET_X + (SHEET_CARD_WIDTH + SHEET_CARD_DISTANCE_X) * xIndex;
        int yPos = SHEET_OFFSET_Y + (SHEET_CARD_HEIGHT + SHEET_CARD_DISTANCE_Y) * yIndex;
        
        Image img = SwingFXUtils.toFXImage(
                cardSheet.getSubimage(xPos, yPos, SHEET_CARD_WIDTH, SHEET_CARD_HEIGHT), null);
        
        return img;
    }
}
}
