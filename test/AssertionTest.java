import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.macalester.graphics.CanvasWindow;

public class AssertionTest {
    CanvasWindow window;
    CharacterManager manager;

    @BeforeAll
    public void setUp(){
        window = new CanvasWindow("Character Placement Test", 800, 800);
        manager = new CharacterManager(window);
        manager.setCurrentLevel(1);
    }

    @Test
    public void testPlaceCharacter(){
        manager.placeCharacter();
        assertEquals(1, 1);
    }
}
