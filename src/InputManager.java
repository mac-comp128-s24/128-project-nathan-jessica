import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.util.ArrayDeque;

/**
 * Manages the input of the user
 * @author Yunzhu (Jessica) Chen
 * @author Nathan Gumagay
 * COMP 128 SPRING 2024
 */
public class InputManager {
    private static CanvasWindow window;
    private CharacterManager characterManager;

    /**
     * 
     * @param window
     * @param characterManager
     */
    public InputManager(CanvasWindow window, CharacterManager characterManager){
        this.window = window;
        this.characterManager = characterManager;
    }

    /**
     * 
     */
    public boolean testHit(Point clickedPoint){
        double clickedX = clickedPoint.getX();
        double clickedY = clickedPoint.getY();
        double[] coordinates = characterManager.getFirstCharacterCoordinate();
        if (clickedX < coordinates[1] && clickedX > coordinates[0]){
            if (clickedY < coordinates[3] && clickedY > coordinates[2]){
                return true;
                
            }
            else {
                return false;
            }
            
        }
        else{
            return false;
        }
    }

}
