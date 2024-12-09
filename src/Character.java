import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import edu.macalester.graphics.Image;

/**
 * A character object is an Graphics Image that stores its name and PNG path.
 * @author Yunzhu (Jessica) Chen
 * @author Nathan Gumagay
 * COMP 128 SPRING 2024
 */
public class Character extends Image{
    private static String pngPath;
    private static String name;
    
    /**
     * Construct a character object that is a graphics image 
     * @param path of the source image in PNG
     * @param name of the character
     * @param manager used to manage the character sequence queue
     */
    public Character(String path, String name){
        super(path);
        this.pngPath = path;
        this.name = name;
    }

    /**
     * @return name of the character
     */
    public String getName(){
        return name;
    }

    /**
     * @return path of the source PNG
     */
    public String getPath(){
        return pngPath;
    }

    /**
     * Set the name of the character with the argument
     * @param name
     */
    private void setName(String name){
        this.name = name;
    }

}
