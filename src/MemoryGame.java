import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

import java.awt.Color;

/**
 * 
 * MemoryGame holds most of the game mechanics and game setUp.
 * @author Yunzhu (Jessica) Chen
 * @author Nathan Gumagay
 * COMP 128 SPRING 2024
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
    private static int avengersSnapped;

    private GraphicsText score = new GraphicsText();
    private GraphicsText lifeScore = new GraphicsText();

    private Image background = new Image("ny.png");

    private Button backToMenu = new Button("Close");

    /**
     * Creates our memory game
     * @param window 
     */
    public MemoryGame(CanvasWindow window){
        this.window = window;
        charManager = new CharacterManager(window);
        inputManager = new InputManager(window, charManager);
        levels = new Levels();
    }

    /**
     * Creates a new game depending on the argument
     * Where everything comes together and makes the game
     * @param level
     */
    public void newGame(int level) {
        this.currentLevel = level;
        charManager.setCurrentLevel(currentLevel);

        this.lifeLeft = levels.getLifesLeft(currentLevel);
        this.pauseTime = levels.getInitialSpeed(currentLevel);
        this.timeElapsed = 0;
        this.avengersSnapped = 0;
        
        setUpBackground();
        setUpLabels();

        window.onMouseDown(event -> onClick(event.getPosition()));

        window.animate(dt -> addCharacterSequence(dt));
    }

    /**
     * Sets up the labels that the player can see
     * Stores the lives, and scores
     */
    private void setUpLabels(){
        Rectangle backing = new Rectangle(30, 5, 375, 75);
        backing.setFillColor(Color.WHITE);
        window.add(backing);

        GraphicsText scoreLabel = new GraphicsText("You snapped: ");
        score.setText(avengersSnapped + " Avengers");

        GraphicsText lifeLabel = new GraphicsText("You have: ");
        lifeScore.setText(lifeLeft + " lives left");

        scoreLabel.setPosition(50, 35);
        scoreLabel.setFontSize(24);

        score.setPosition(50 + scoreLabel.getWidth() + 20, 35);
        score.setFontSize(24);

        window.add(scoreLabel);
        window.add(score);

        lifeLabel.setPosition(50, 65);
        lifeLabel.setFontSize(24);

        lifeScore.setPosition(50 + scoreLabel.getWidth() + 20, 65);
        lifeScore.setFontSize(24);

        window.add(lifeLabel);
        window.add(lifeScore);
    }

    /**
     * Sets up our background
     */
    private void setUpBackground(){
        background.setImagePath(levels.getBackground(currentLevel));
        background.setMaxWidth(window.getWidth());
        background.setCenter(window.getCenter());
        window.add(background);
    }
    /**
     * Based on our argument the method will change the score for the player as well as remove the character on the point
     * @param clickedPoint
     */
    private void onClick(Point clickedPoint){
        if(inputManager.testHit(clickedPoint)){
            avengersSnapped += 1;
            score.setText(avengersSnapped + " Avengers");
            charManager.removeCharacter();
        }
        else{
            lifeLeft -= 1;
            lifeScore.setText("" + lifeLeft  + "  lives left");
        }
    }

    /**
     * Depending on our argument the method will add a characyer to both the queue as well as the canvas
     * @param dt
     */
    private void addCharacterSequence(double dt){
        if (lifeLeft > 0 && charManager.getCharacterSequence().size() <= 5) {
            if (timeElapsed >= pauseTime) {
            charManager.placeCharacter();
            timeElapsed = 0;
            pauseTime *= 0.95;
        }
        timeElapsed += dt;
        }
        else {
            endGame();
        }
    }

    /**
     * Ends the game
     */
    private void endGame(){
       window.removeAll();
       window.setBackground(Color.GRAY);
       Image thanosDeath = new Image("thanos_death.jpg");
       thanosDeath.setCenter(window.getCenter());
       window.add(thanosDeath);
       Image gameOver = new Image("game_over_text.png");
       gameOver.setCenter(window.getCenter());
       window.add(gameOver);

       addBackToMenuButton();
       backToMenu.onClick(() -> {
        window.closeWindow();
       });

    }

    /**
     * Button that allows the user to go back to the main menu after losing
     */
    private void addBackToMenuButton(){
        backToMenu.setCenter(window.getWidth()/2, window.getHeight()-300);
        window.add(backToMenu);
    }
}
