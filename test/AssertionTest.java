import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import edu.macalester.graphics.CanvasWindow;

public class AssertionTest {
    
    CharacterManager manager = new CharacterManager(null);
    Queue<Character> characterSequence = new LinkedList<>();

        @Test
    public void testPlaceCharacter(){
        manager.placeCharacter();
        assertEquals(, characterSequence.peek());
    }
}
