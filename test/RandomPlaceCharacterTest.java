import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;

public class RandomPlaceCharacterTest {

    public static void main(String[] args) {
        CanvasWindow window = new CanvasWindow("Character Placement Test", 800, 800);
        window.setBackground(Color.BLUE);
       
        CharacterManager manager = new CharacterManager(window);
        manager.setCurrentLevel(3);
        
        manager.placeCharacter();

        GraphicsText name = new GraphicsText(manager.getCharacterSequence().peek().getName());
        name.setCenter(300,50);
        name.setFontSize(50);
        window.add(name);
    }
}
