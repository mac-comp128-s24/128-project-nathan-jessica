import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;

public class PlaceCharacterTest {



    public static void main(String[] args) {
        CanvasWindow window = new CanvasWindow("Character Placement Test", 800, 800);
        window.setBackground(Color.BLUE);
       
        CharacterManager manager = new CharacterManager(window);
        manager.setCurrentLevel(1);
        manager.placeCharacter();
        GraphicsText name = new GraphicsText(manager.getCharacterSequence().peek().getName());
        window.add(name);
    }
}
