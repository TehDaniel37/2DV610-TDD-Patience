package test.view;


import javafx.scene.Scene;
import javafx.stage.Stage;
import main.view.GameTableView;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class GameTableViewTest extends ApplicationTest {

    private GameTableView sut;

    @Before
    public void beforeEach() {
        sut = new GameTableView();
    }


    @Test
    public void constructorShouldCreateVisualStackArrayList() {
        assertNotNull(sut.getVisualStacks());
    }

    @Test
    public void constructorShouldCreateGridPane() {
        assertNotNull(sut.getStackGridPane());
    }

    @Test
    public void constructorShouldAddGridPaneToGameTableView() {
        assertNotNull(sut.getContent());
    }


    @Override
    public void start(Stage stage) throws Exception {
        
    }
}