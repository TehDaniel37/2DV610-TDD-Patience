package test.view;

import main.view.GameTableView;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTableViewTest {


    @Test
    public void constructorShouldCreateVisualStackArrayList() {
        GameTableView sut = new GameTableView();

        assertNotNull(sut.getVisualStacks());
    }

    @Test
    public void constructorShouldCreateGridPane() {
        GameTableView sut = new GameTableView();

        assertNotNull(sut.getStackGridPane());
    }
}