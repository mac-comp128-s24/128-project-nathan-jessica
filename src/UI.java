import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
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
        addButton();
    }

    private void addBackground(){
        Rectangle background = new Rectangle(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        background.setFillColor(Color.red);
        window.add(background);
    }

    private void addScreen(){
        Rectangle screen = new Rectangle(80,50, WINDOW_WIDTH - 200, WINDOW_HEIGHT / 2);
        screen.setFillColor(Color.WHITE);
        window.add(screen);
    }

    private void addButton(){
        Button enter = new Button("Enter");
        window.add(enter, WINDOW_WIDTH - 100, WINDOW_HEIGHT / 1.5);
    }


    public static void main(String[] args) {
        new UI();
        MemoryGame game = new MemoryGame(window);
        game.newGame(1);

    }

}
