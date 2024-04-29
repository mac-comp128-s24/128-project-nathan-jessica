import java.util.HashMap;

/**
 * 
 */
public class Levels {
    private static HashMap<Integer, String[]> levels = new HashMap<Integer, String[]>();
    private static String[] level1 = 
        {"Black Widow", "Captain America", "Hawkeye", "Hulk", "Iron Man", "Thor"};
    private static String[] level2 = 
        {"Black Widow", "Captain America", "Hawkeye", "Hulk", "Iron Man", "Thor", 
        "Vision", "Wanda", "Quick Silver", "Falcon", "War Machine"};
    private static String[] level3 = 
        {"Black Widow", "Captain America", "Hawkeye", "Hulk", "Iron Man", "Thor", 
        "Vision", "Wanda", "Falcon", "Black Panther", "Baby Groot", "Star Lord", 
        "Rocket", "Drax", "Spiderman", "Valkyrie", "Mantis", "Doctor Strange", 
        "Okoye", "War Machine", "Gamora"};
    private static int[] livesLeft = {3, 2, 1};
    private static double[] initialSpeed = {1, 0.9, 0.8};
    
    /**
     * 
     */
    public Levels(){
        levels.put(1, level1);
        levels.put(2, level2);
        levels.put(3, level3);
    }

    
    public String[] get(int levelNumber){
        return levels.get(levelNumber);
    }

    
    public int getLifesLeft(int levelNumber){
        return livesLeft[levelNumber - 1];
    }

    public double getInitialSpeed(int levelNumber){
        return initialSpeed[levelNumber - 1];
    }
}
