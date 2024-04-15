import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.util.ArrayDeque;

/**
 * 
 */
public class InputManager {
    private static CanvasWindow window;
    
    private static ArrayDeque<Character> UserInput;

    public InputManager(CanvasWindow window){
        this.window = window;
        UserInput = new ArrayDeque<Character>();
    }

    public Character getCharacter(Point clickedPoint){

    }

}
