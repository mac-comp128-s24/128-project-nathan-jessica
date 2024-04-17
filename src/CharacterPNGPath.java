import java.util.HashMap;

public class CharacterPNGPath{
    public static HashMap<String, String> characterPath = new HashMap<String, String>();

    /**
     * 
     */
    public CharacterPNGPath(){
        characterPath.put("Black Panther", "res/black.panther.png");
        characterPath.put("Black Widow", "res/black.widow.png");
        characterPath.put("Captain America", "res/captain.america.png");
        characterPath.put("Hawkeye", "res/hawkeye.png");
        characterPath.put("Hulk", "res/hulk.png");
        characterPath.put("Iron Man", "res/iron.man.png");
        characterPath.put("Scarlet Witch", "res/scarlet.witch.png");
        characterPath.put("Star Lord", "res/star.lord.png");
        characterPath.put("Thor", "res/thor.png");
        characterPath.put("Vision", "res/vision.png");
    }

    /**
     * 
     * @param name of the character
     * @return Path of the character PNG
     */
    public String get(String name){
        return characterPath.get(name);
    }
}
