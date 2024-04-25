import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.util.Timer;

/**
 * 
 */
public class MemoryGame {
    private static CharacterManager charManager;
    private static InputManager inputManager;
    private static CanvasWindow window;

    private static Levels levels;
    private static int currentLevel;

    private static int lifeLeft;
    private static boolean win;

    private static Timer timer = new Timer();


    public MemoryGame(CanvasWindow window){
        this.window = window;
        charManager = new CharacterManager(window);
        inputManager = new InputManager(window, charManager);
        levels = new Levels();
    }

    public void newGame(int level) {
        this.currentLevel = level;
        charManager.setCurrentLevel(currentLevel);

        this.lifeLeft = levels.getLifesLeft(currentLevel);

        window.onMouseDown(event -> onClick(event.getPosition()));
        addCharacterSequence(levels.getInitialSpeed(currentLevel));
    }

    private void onClick(Point clickedPoint){
        if(inputManager.testHit(clickedPoint)){
            charManager.removeCharacter();
        }
        else{
            lifeLeft -= 1;
        }
    }

    private void addCharacterSequence(double initialSpeed) {
        double pauseTime = initialSpeed;
        //while (lifeLeft > 0) {
            charManager.placeCharacter();
            //window.pause(pauseTime*1000);
            pauseTime = pauseTime * 0.95;
        //}
    }

    // //https://stackoverflow.com/a/48246529 by M Imam Pratama
    // public static void pause(double seconds) {
    //     try {
    //         Thread.sleep((long) (seconds * 1000));
    //     } catch (InterruptedException e) {
    //         System.out.println("Pause Failed");
    //     }
    // }

    private void endGame(){
       
    }

}
