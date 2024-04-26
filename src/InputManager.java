import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.util.ArrayDeque;

/**
 * 
 */
public class InputManager {
    private static CanvasWindow window;
    private CharacterManager characterManager;
    //private int lives = 1;

    public InputManager(CanvasWindow window, CharacterManager characterManager){
        this.window = window;
        this.characterManager = characterManager;
    }


    public boolean testHit(Point clickedPoint){
        double clickedX = clickedPoint.getX();
        double clickedY = clickedPoint.getY();
        System.out.println("Clicked: " + clickedX + ", " + clickedY);
        double[] coordinates = characterManager.getFirstCharacterCoordinate();
        for (double gotCoordinate: coordinates) {
            System.out.println("Got from first:" + gotCoordinate + " --> ");
        }
        if (clickedX < coordinates[1] && clickedX > coordinates[0]){
            System.out.println("x in bound");
            if (clickedY < coordinates[3] && clickedY > coordinates[2]){
                System.out.println("y in bound");
                System.out.println("HITTTTTT");
                return true;
                
            }
            else {
                System.out.println("y out of bound");
                return false;
            }
            
        }
        else{
            System.out.println("x out of bound");
            return false;
        }
        // if(clickedY > coordinates[4] || clickedY < coordinates[3]){
        //     System.out.println("y out of bound");
        //     return false;
        // }
    }

}
