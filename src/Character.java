import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import edu.macalester.graphics.Image;

/**
 * 
 */
public class Character extends Image{
    private static String pngPath;
    private static String name;
    private static CharacterManager manager;
    private static Double size;
    
    /**
     * Construct a character object that is a graphics image 
     * @param path of the source image in PNG
     * @param name of the character
     * @param manager used to manage the character sequence queue
     */
    public Character(String path, String name, CharacterManager manager){
        super(path);
        this.pngPath = path;
        this.name = name;
        this.manager = manager;
    }

    /**
     * @return
     */
    private String getName(){
        return name;
    }

    private String getPath(){
        return pngPath;
    }

    private void setName(String name){
        this.name = name;
    }

    private void appear(){
        
    }

    private void clicked(){
        
    }

    private void checkQueue(){

    }
}
