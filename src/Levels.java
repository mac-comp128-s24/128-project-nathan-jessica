import java.util.HashMap;

/**
 * 
 */
public class Levels {
    private static HashMap<Integer, String[]> levels = new HashMap<Integer, String[]>();
    private static String[] level1 = 
        {"Black Widow", "Captain America", "Hawkeye", "Hulk", "Iron Man", "Thor"};

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
