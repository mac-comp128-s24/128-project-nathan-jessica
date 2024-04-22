import java.util.HashMap;

/**
 * 
 */
public class Levels {
    private static HashMap<Integer, String[]> levels = new HashMap<Integer, String[]>();
    private static String[] level1 = 
        {"Black Panther", "Black Widow", "Captain America", "Haweye", "Hawk", "Iron Man"};

    /**
     * 
     */
    public Levels(){
        levels.put(1, level1);
    }

    
    public String[] get(int levelNumber){
        return levels.get(levelNumber);
    }
}
