import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.macalester.graphics.CanvasWindow;

public class AssertionTest {
    
    CharacterManager manager = new CharacterManager(null);
    Queue<Character> characterSequence = new LinkedList<>();

    @Test
    public void testPlaceCharacter(){
        manager.setCurrentLevel(1);
        manager.placeCharacter();
        assertEquals(manager.getCharacterSequence().size(), 1);
    }
}
