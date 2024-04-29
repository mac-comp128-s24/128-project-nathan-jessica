import java.util.HashMap;

public class CharacterPNGPath{
    public static HashMap<String, String> characterPath = new HashMap<String, String>();

    /**
     * 
     */
    public CharacterPNGPath(){
        characterPath.put("Black Panther", "black_panther.png");
        characterPath.put("Black Widow", "black_widow.png");
        characterPath.put("Captain America", "captain_america.png");
        characterPath.put("Hawkeye", "hawkeye.png");
        characterPath.put("Hulk", "hulk.png");
        characterPath.put("Iron Man", "ironman.png");
        characterPath.put("Scarlet Witch", "scarlet_witch.png");
        characterPath.put("Star Lord", "star_lord.png");
        characterPath.put("Thor", "thor.png");
        characterPath.put("Vision", "vision.png");
        characterPath.put("Baby Groot", "baby_groot.png");
        characterPath.put("Quick Silver", "quick_silver.png");
        characterPath.put("Falcon",  "falcon.png");
        characterPath.put("Doctor Strange", "doctor_strange.png");
        characterPath.put("Drax", "drax.png");
        characterPath.put("Gamora", "gamora.png");
        characterPath.put("Mantis", "mantis.png");
        characterPath.put("Okoye", "okoye.png");
        characterPath.put("Rocket", "rocket.png");
        characterPath.put("Spiderman", "spiderman.png");
        characterPath.put("Valkyrie", "valkyrie.png");
        characterPath.put("War Machine", "war_machine.png");
    }

    /**
     * 
     * @param name of the character
     * @return Path of the character PNG
     */
    public String get(String name){
        return characterPath.get(name);
    }

    public HashMap<String, String> getMapping(){
        return characterPath;
    }
}
