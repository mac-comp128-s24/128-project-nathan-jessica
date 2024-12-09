import java.util.HashMap;

/**
 * Stores the different levels to our game
 * @author Yunzhu (Jessica) Chen
 * @author Nathan Gumagay
 * COMP 128 SPRING 2024
 */
public class Levels {
    private static HashMap<Integer, String[]> levels = new HashMap<Integer, String[]>();
    private static String[] level1 = 
        {"Black Widow", "Captain America", "Hawkeye", "Hulk", "Iron Man", "Thor"};
    private static String[] level2 = 
        {"Black Widow", "Captain America", "Hawkeye", "Hulk", "Iron Man", "Thor", 
        "Vision", "Scarlet Witch", "Quick Silver", "Falcon", "War Machine"};
    private static String[] level3 = 
        {"Black Widow", "Captain America", "Hawkeye", "Hulk", "Iron Man", "Thor", 
        "Vision", "Scarlet Witch", "Falcon", "Black Panther", "Baby Groot", "Star Lord", 
        "Rocket", "Drax", "Spiderman", "Valkyrie", "Mantis", "Doctor Strange", 
        "Okoye", "War Machine", "Gamora"};
    private static int[] livesLeft = {3, 2, 1};
    private static double[] initialSpeed = {1, 0.9, 0.8};
    private static String[] background = {"ny.jpg", "Ultron.jpg", "infinity_war_bg.jpg"};
    
    /**
     * Creates our levels
     */
    public Levels(){
        levels.put(1, level1);
        levels.put(2, level2);
        levels.put(3, level3);
    }

    /**
     * @param levelNumber
     * @return A certain group of characters for the certain level
     */
    public String[] get(int levelNumber){
        return levels.get(levelNumber);
    }

    /**
     * 
     * @param levelNumber
     * @return The amount of lives alotted to each level
     */
    public int getLifesLeft(int levelNumber){
        return livesLeft[levelNumber - 1];
    }

    /**
     * 
     * @param levelNumber
     * @return the initial speed of the certain levekl
     */
    public double getInitialSpeed(int levelNumber){
        return initialSpeed[levelNumber - 1];
    }

    /**
     * 
     * @param levelNumber
     * @return the background for the certain argument
     */
    public String getBackground(int levelNumber){
        return background[levelNumber - 1];
    }
}
