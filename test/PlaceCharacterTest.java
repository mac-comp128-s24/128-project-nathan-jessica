import org.junit.jupiter.api.Test;

import edu.macalester.graphics.CanvasWindow;

public class PlaceCharacterTest {

    public static void main(String[] args) {
        CanvasWindow window = new CanvasWindow("Character Placement Test", 800, 800);
        CharacterManager manager = new CharacterManager(window);
        manager.setCurrentLevel(1);
        manager.placeCharacter();
    }

    @Test
    public void testPlaceCharacter(){
        
    }
}
