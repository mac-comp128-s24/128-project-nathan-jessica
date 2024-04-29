import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

import java.awt.Color;
import java.util.HashMap;

public class AllCharacterFileTest {
    public static void main(String[] args) {
        CanvasWindow window = new CanvasWindow("Character Placement Test", 1200, 800);
        window.setBackground(Color.BLUE);

        CharacterPNGPath pathMap = new CharacterPNGPath();

        int x = 0;
        int y = 0;

        int size = 200;

        HashMap<String, String> mapping = pathMap.getMapping();
        for (String character: mapping.keySet()){
            if(x > 1200 - size){
                x = 0;
                y += 200;
            }
            Image characterImage = new Image("baby_groot.png");
            characterImage.setMaxHeight(size);
            characterImage.setMaxWidth(size);
            characterImage.setImagePath(mapping.get(character));
            window.add(characterImage, x, y);
            GraphicsText name = new GraphicsText(character);
            name.setFillColor(Color.white);
            name.setFontSize(20);
            window.add(name, x, y + 100);
            window.draw();
            x += 200;
        }
    }
}
