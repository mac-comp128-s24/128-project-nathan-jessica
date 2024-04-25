import java.util.HashMap;

/**
 * 
 */
public class Levels {
    private static HashMap<Integer, String[]> levels = new HashMap<Integer, String[]>();
    private static String[] level1 = 
        {"Black Widow", "Captain America", "Hawkeye", "Hulk", "Iron Man", "Thor"};
    private static int[] livesLeft = {3, 2, 1};
    private static double[] initialSpeed = {1, 0.75, 0.25};
    
    /**
     * 
     */
    public Levels(){
        levels.put(1, level1);
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
