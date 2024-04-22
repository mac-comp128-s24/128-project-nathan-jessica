import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.macalester.graphics.CanvasWindow;

public class PlaceCharacterTest {

    CharacterManager

    public static void main(String[] args) {
        CanvasWindow window = new CanvasWindow("Character Placement Test", 800, 800);
        CharacterManager manager = new CharacterManager(window);
        Character character = new Character("blackpanther.png", "Black Panther");
        window.add(character);
        //manager.placeCharacter();
    }
}
