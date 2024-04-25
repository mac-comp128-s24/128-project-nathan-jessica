import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.util.concurrent.TimeUnit;

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
            endGame();
        }
    }

    private void addCharacterSequence(double initialSpeed) {
        double pause = initialSpeed;
        while (lifeLeft > 0) {
            charManager.placeCharacter();
            // try {
            //     TimeUnit.SECONDS.sleep((long) pause);
            // } catch (InterruptedException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }
            //window.wait((long)pause);
            pause = pause * 0.9;
        }
    }

    private void endGame(){
        window.removeAll();
    }

}
