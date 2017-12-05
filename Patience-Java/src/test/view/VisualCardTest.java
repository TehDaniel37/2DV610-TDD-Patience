package test.view;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import main.model.Card;
import main.model.Color;
import main.model.Value;
import main.view.VisualCard;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VisualCardTest {

    private static final int SHEET_OFFSET_X = 38;
    private static final int SHEET_OFFSET_Y = 29;
    private static final int SHEET_CARD_DISTANCE_X = 28;
    private static final int SHEET_CARD_DISTANCE_Y = 28;
    private static final int SHEET_CARD_WIDTH = 362;
    private static final int SHEET_CARD_HEIGHT = 542;

    private static BufferedImage cardImagesSheet;
    private static Image cardImageEightOfDiamonds;

    @BeforeClass
    public static void beforeClass() throws IOException {
        cardImagesSheet = ImageIO.read(VisualCardTest.class.getClassLoader().getResource("cards.png"));
        
        cardImageEightOfDiamonds = SwingFXUtils.toFXImage(cardImagesSheet.getSubimage(
                SHEET_OFFSET_X + (SHEET_CARD_WIDTH + SHEET_CARD_DISTANCE_X) * 7,
                SHEET_OFFSET_Y + (SHEET_CARD_HEIGHT + SHEET_CARD_DISTANCE_Y) * 2,
                SHEET_CARD_WIDTH,
                SHEET_CARD_HEIGHT),
                null);
    }


    @Test
    public void constructorShouldSetCorrectImage() {
        Card mockCard = mock(Card.class);
        when(mockCard.getColor()).thenReturn(Color.Diamonds);
        when(mockCard.getValue()).thenReturn(Value.Eight);

        VisualCard vCard = new VisualCard(mockCard);
        
        assertImagesEqual(cardImageEightOfDiamonds, vCard.getImage());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void constructorShouldThrowIllegalArgumentExceptionWhenCardIsNull() {
        VisualCard vCard = new VisualCard(null);
    }

    private void assertImagesEqual(Image expected, Image actual) {
        Dimension expectedSize = new Dimension((int)expected.getWidth(), (int)expected.getHeight());

        for (int x = 0; x < expectedSize.width; x++) {
            for (int y = 0; y < expectedSize.height; y++) {
                assertEquals(expected.getPixelReader().getArgb(x, y), actual.getPixelReader().getArgb(x, y));
            }
        }
    }
}
