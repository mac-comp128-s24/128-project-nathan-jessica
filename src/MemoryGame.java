import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
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
    private GraphicsText lifeScore = new GraphicsText();
    private Image background = new Image("ny.png");


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
        
        setUpLabels();

        window.onMouseDown(event -> onClick(event.getPosition()));

        window.animate(dt -> addCharacterSequence(dt));
    }

    private void setUpLabels(){
        GraphicsText timeScoreLabel = new GraphicsText("You survived: ");
        timeScore.setText("" + (int) timeSurvived + " seconds");

        GraphicsText lifeLabel = new GraphicsText("You have: ");
        lifeScore.setText("" + lifeLeft + " lives left");

        timeScoreLabel.setPosition(50, 35);
        timeScoreLabel.setFontSize(24);

        timeScore.setPosition(50 + timeScoreLabel.getWidth() + 20, 35);
        timeScore.setFontSize(24);

        window.add(timeScoreLabel);
        window.add(timeScore);

        lifeLabel.setPosition(50, 65);
        lifeLabel.setFontSize(24);

        lifeScore.setPosition(50 + timeScoreLabel.getWidth() + 20, 65);
        lifeScore.setFontSize(24);

        window.add(lifeLabel);
        window.add(lifeScore);
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
            lifeScore.setText("" + lifeLeft  + "  lives left");
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
       window.setBackground(Color.GRAY);
       Image gameOver = new Image("game_over_text.png");
       gameOver.setCenter(window.getWidth()/2, window.getHeight()/2);
       window.add(gameOver);
    }

}
