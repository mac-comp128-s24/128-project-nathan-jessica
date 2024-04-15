import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import edu.macalester.graphics.GraphicsObject;

/**
 * 
 */
public class Character extends GraphicsObject{
    private static String pngPath;
    private static String name;
    private static CharacterManager manager;
    
    public Character(String path, String name, CharacterManager manager){
        this.pngPath = path;
        this.name = name;
        this.manager = manager;
    }

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

    @Override
    protected void drawInLocalCoordinates(Graphics2D gc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawInLocalCoordinates'");
    }

    @Override
    public boolean testHitInLocalCoordinates(double x, double y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'testHitInLocalCoordinates'");
    }

    @Override
    public Rectangle2D getBounds() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBounds'");
    }

    @Override
    protected Object getEqualityAttributes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEqualityAttributes'");
    }
}
