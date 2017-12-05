package test.view;

import main.view.GameTableView;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTableViewTest {

    GameTableView sut;

    @Before
    public void beforeEach() {
        sut = new GameTableView();
    }


    @Test
    public void constructorShouldCreateVisualStackArrayList() {
        sut = new GameTableView();

        assertNotNull(sut.getVisualStacks());
    }

    @Test
    public void constructorShouldCreateGridPane() {
        sut = new GameTableView();

        assertNotNull(sut.getStackGridPane());
    }
}