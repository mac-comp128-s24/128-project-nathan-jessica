import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

/**
 * 
 */
public class UI{
    private static CanvasWindow window;
    private final static int WINDOW_HEIGHT = 1000;
    private final static int WINDOW_WIDTH = 1500;

    /**
     * 
     */
    public UI(){
        window = new CanvasWindow("Memory Game", WINDOW_WIDTH, WINDOW_HEIGHT);
        addBackground();
        addScreen();
        addThanos();
        addLevel1Button();
        //addLevel2Button();
        //addLevel3Button();
    }

    private void addBackground(){
        Rectangle background = new Rectangle(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        background.setFillColor(Color.black);
        window.add(background);
    }

    private void addScreen(){
        Rectangle screen = new Rectangle(80,50, WINDOW_WIDTH - 200, WINDOW_HEIGHT / 2);
        screen.setFillColor(Color.WHITE);
        window.add(screen);
    }

    private void addTitle(){
        GraphicsText title = new GraphicsText("Thanos Memory Game");
    }

    private void addThanos(){
        Image thanos = new Image("thanos.png");
        thanos.setPosition(500,500);
        window.add(thanos);
    }

    private void addLevel1Button(){
        Button firstLevel = new Button("Level 1");
        window.add(firstLevel, WINDOW_WIDTH - 700, WINDOW_HEIGHT - 900);
        firstLevel.onClick(() -> {
            window.draw();
            window.removeAll();
            MemoryGame game = new MemoryGame(window);
            game.newGame(1);
        });
    }

    private void addLevel2Button(){
        Button secondLevel = new Button("Level 2");
        window.add(secondLevel, WINDOW_WIDTH - 150, WINDOW_HEIGHT / 2);
        secondLevel.onClick(() -> {
            window.draw();
            window.removeAll();
            MemoryGame game = new MemoryGame(window);
            game.newGame(2);
        });
    }

    private void addLevel3Button(){
        Button firstLevel = new Button("Level 3");
        window.add(firstLevel, WINDOW_WIDTH - 200, WINDOW_HEIGHT / 2);
        firstLevel.onClick(() -> {
            window.draw();
            window.removeAll();
            MemoryGame game = new MemoryGame(window);
            game.newGame(3);
        });
    }


    public static void main(String[] args) {
        new UI();
    }

}
