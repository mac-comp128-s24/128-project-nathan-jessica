import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.util.ArrayDeque;

/**
 * 
 */
public class InputManager {
    private static CanvasWindow window;
    private CharacterManager characterManager;

    public InputManager(CanvasWindow window, CharacterManager characterManager){
        this.window = window;
        this.characterManager = characterManager;
    }


    public boolean testHit(Point clickedPoint){
        double clickedX = clickedPoint.getX();
        double clickedY = clickedPoint.getY();
        double[] coordinates = characterManager.getFirstCharacterCoordinate();
        if(clickedX > coordinates[2] || clickedX < coordinates[1]){
            return false;
        }
        if(clickedY > coordinates[4] || clickedY < coordinates[3]){
            return false;
        }
        return true;
    }

}
