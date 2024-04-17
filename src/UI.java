import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

/**
 * 
 */
public class UI{
    private static CanvasWindow window;
    private final static int WINDOW_HEIGHT = 800;
    private final static int WINDOW_WIDTH = 1500;

    /**
     * 
     */
    public UI(){
        window = new CanvasWindow("Memory Game", WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    //private addBackground(){
        
        //GraphicsObject object = new Rectangle(null, null);
    //}

    public static void main(String[] args) {
        new UI();
        new CharacterManager(window);
    }

}
