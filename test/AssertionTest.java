import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.macalester.graphics.CanvasWindow;

public class AssertionTest {
    CanvasWindow window = new CanvasWindow("testWindow", 100, 500);
    CharacterManager manager = new CharacterManager(window);

    @Test
    public void testPlaceCharacter(){
        manager.setCurrentLevel(1);
        manager.placeCharacter();
        assertEquals(manager.getCharacterSequence().size(), 1);
    }
}
