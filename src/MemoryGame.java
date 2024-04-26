import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Point;

import java.awt.Color;

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

    private static double pauseTime;
    private static double timeElapsed;
    private static double timeSurvived;
    private GraphicsText timeScore = new GraphicsText();


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
        this.pauseTime = levels.getInitialSpeed(currentLevel);
        this.timeElapsed = 0;
        this.timeSurvived = 0;

        GraphicsText timeScoreLabel = new GraphicsText("You survived: ");
        timeScore.setText("" + (int) timeSurvived + " seconds");
        
        timeScoreLabel.setPosition(50, 35);
        timeScoreLabel.setFontSize(24);
        timeScore.setPosition(50 + timeScoreLabel.getWidth() + 20, 35);
        timeScore.setFontSize(24);
        window.add(timeScoreLabel);
        window.add(timeScore);

        window.onMouseDown(event -> onClick(event.getPosition()));

        window.animate(dt -> addCharacterSequence(dt));
    }

    private void onClick(Point clickedPoint){
        System.out.println("Clicked-------------------------------------------");
        if(inputManager.testHit(clickedPoint)){
            System.out.println("Hit!");
            charManager.removeCharacter();
            window.draw();
            System.out.println("Life Left:" + lifeLeft);
        }
        else{
            System.out.println("NO HIT");
            lifeLeft -= 1;
            System.out.println("Life Left:" + lifeLeft);
        }
    }

    private void addCharacterSequence(double dt){
        if (lifeLeft > 0) {
            if (timeElapsed >= pauseTime) {
            charManager.placeCharacter();
            timeElapsed = 0;
            pauseTime *= 0.95;
        }
        timeElapsed += dt;
        timeSurvived += dt;
        timeScore.setText("" + (int) timeSurvived  + " seconds");
        }
        else {
            endGame();
        }
    }

    //https://www.baeldung.com/java-measure-elapsed-time
    public static void pause(double seconds) {
        long startTime = System.currentTimeMillis();
        long timeNow = System.currentTimeMillis();
        long timePast = timeNow - startTime;
        while (timePast < seconds * 1000) {
            timeNow = System.currentTimeMillis();
            timePast = timeNow - startTime;
        }
        System.out.println(seconds + "second passed");
    }

    private void endGame(){
       window.removeAll();
       window.setBackground(Color.BLACK);
    }

}
