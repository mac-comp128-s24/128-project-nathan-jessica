import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.macalester.graphics.CanvasWindow;

public class CharacterSequenceAssertionTest {
    private static CanvasWindow window;
    private static CharacterManager manager;

    @BeforeEach
    public void setUp(){
        window = new CanvasWindow("Character Placement Test", 800, 800);
        manager = new CharacterManager(window);
        manager.setCurrentLevel(1);
    }

    @Test
    public void testPlaceCharacter(){
        manager.placeCharacter();
        assertEquals(1, manager.getCharacterSequence().size());

        manager.placeCharacter();
        assertEquals(2, manager.getCharacterSequence().size());

        manager.placeCharacter();
        manager.placeCharacter();
        manager.placeCharacter();
        assertEquals(5, manager.getCharacterSequence().size());
    }

    @Test
    public void testRemoveCharacter(){
        manager.placeCharacter();
        manager.removeCharacter();
        assertEquals(0, manager.getCharacterSequence().size());

        manager.placeCharacter();
        manager.placeCharacter();
        manager.placeCharacter();
        manager.removeCharacter();
        assertEquals(2, manager.getCharacterSequence().size());

        manager.removeCharacter();
        manager.removeCharacter();
        manager.removeCharacter();
        assertEquals(0, manager.getCharacterSequence().size());


    }
}
