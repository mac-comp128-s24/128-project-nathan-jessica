import java.util.HashMap;

public class CharacterPNGPath{
    public static HashMap<String, String> characterPath = new HashMap<String, String>();

    /**
     * 
     */
    public CharacterPNGPath(){
        characterPath.put("Black Panther", "blackpanther.png");
        characterPath.put("Black Widow", "blackwidow.png");
        characterPath.put("Captain America", "captainamerica.png");
        characterPath.put("Hawkeye", "hawkeye.png");
        characterPath.put("Hulk", "hulk.png");
        characterPath.put("Iron Man", "ironman.png");
        characterPath.put("Scarlet Witch", "scarletwitch.png");
        characterPath.put("Star Lord", "starlord.png");
        characterPath.put("Thor", "thor.png");
        characterPath.put("Vision", "vision.png");
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
