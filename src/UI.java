import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

/**
 * Set up the main UI.
 * Contains the Main Methods
 * @author Yunzhu (Jessica) Chen
 * @author Nathan Gumagay
 * COMP 128 SPRING 2024
 */
public class UI{
    private static CanvasWindow window;
    private final static int WINDOW_HEIGHT = 1000;
    private final static int WINDOW_WIDTH = 1500;

    /**
     * Create a new UI object.
     * Create a new window and set up the main menu.
     */
    public UI(){
        window = new CanvasWindow("Memory Game", WINDOW_WIDTH, WINDOW_HEIGHT);
        setUpMainMenu();
    }

    /**
     * Set up the main menu.
     */
    private void setUpMainMenu(){
        addBackground();
        addScreen();
        addFirstThanos();
        addSecondThanos();
        addLevel1Button();
        addLevel2Button();
        addLevel3Button();
        addQuestionButton();
        addTitle();
    }

    /**
     * Add the background image of the main menu.
     */
    private void addBackground(){
        Rectangle background = new Rectangle(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        background.setFillColor(Color.red);
        window.add(background);
    }

    /**
     * Add the Screen imgae of the main menu.
     */
    private void addScreen(){
        Rectangle screen = new Rectangle(80,50, WINDOW_WIDTH - 200, WINDOW_HEIGHT / 2);
        screen.setFillColor(Color.WHITE);
        window.add(screen);
    }

    /**
     * Add the title of the game to the main menu.
     */
    private void addTitle(){
        GraphicsText title = new GraphicsText("Thanos Memory Game");
        title.setPosition(275, WINDOW_HEIGHT - 700);
        title.setFontStyle(FontStyle.BOLD_ITALIC);
        title.setFontSize(80);
        window.add(title);
    }

    /**
     * Add a Thanos image to the main menu.
     */
    private void addFirstThanos(){
        Image thanos = new Image("thanos_infinity.png");
        thanos.setMaxWidth(200);
        thanos.setMaxHeight(250);
        thanos.setPosition(WINDOW_WIDTH - 300,WINDOW_HEIGHT - 700);
        window.add(thanos);
    }

    /**
     * Add another Thanos image to the main menu.
     */
    private void addSecondThanos(){
        Image thanos = new Image("thanos.png");
        thanos.setPosition(80,325);
        thanos.setMaxWidth(300);
        thanos.setMaxHeight(500);
        window.add(thanos);
    }

    /**
     * Add the question button which displays the instruction to the game.
     */
    private void addQuestionButton(){
        Button question = new Button("?");
        question.setCenter(WINDOW_WIDTH/2, WINDOW_HEIGHT - 650);

        window.add(question);

        question.onClick(() -> {
            window.removeAll();
            GraphicsText questionAnswer = new GraphicsText();
            questionAnswer.setText("Members of the Avengers will appear in order.\nYour duty as Thanos is to snap them away one by one in order by clicking them. \nIf you snap out of order, you will lose a life. \nWhen all lives are lost, the game ends. \nIf you allow more than 5 avengers to be present at once, \nyou will die and the game ends.");
            questionAnswer.setCenter(window.getCenter());
            window.add(questionAnswer);

            // Add the Back button that goes back to the main menu.
            Button backButton = new Button("Back");
            backButton.setCenter(WINDOW_WIDTH/2, WINDOW_HEIGHT-400);
            window.add(backButton);
            backButton.onClick(() -> {
                window.removeAll();
                setUpMainMenu();
            });
        });
    }

    /**
     * Add the level 1 button which begins the game at level 1.
     */
    private void addLevel1Button(){
        Button firstLevel = new Button("Battle of New York");
        firstLevel.setCenter(WINDOW_WIDTH/2, WINDOW_HEIGHT - 600);
        window.add(firstLevel);
        firstLevel.onClick(() -> {
            window.removeAll();
            MemoryGame game = new MemoryGame(window);
            game.newGame(1);
        });
    }

    /**
     * Add the level 2 button which begins the game at level 2.
     */
    private void addLevel2Button(){
        Button secondLevel = new Button("Age of Ultron");
        secondLevel.setCenter(WINDOW_WIDTH/2, WINDOW_HEIGHT - 550);
        window.add(secondLevel);
        secondLevel.onClick(() -> {
            window.removeAll();
            MemoryGame game = new MemoryGame(window);
            game.newGame(2);
        });
    }

    /**
     * Add the level 3 button which begins the game at level 3.
     */
    private void addLevel3Button(){
        Button thirdLevel = new Button("Infinity War");
        thirdLevel.setCenter(WINDOW_WIDTH/2, WINDOW_HEIGHT - 500);
        window.add(thirdLevel);
        thirdLevel.onClick(() -> {
            window.removeAll();
            MemoryGame game = new MemoryGame(window);
            game.newGame(3);
        });
    }


    public static void main(String[] args) {
        new UI();
    }

}
