import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 
 */
public class CharacterManager {
    private static ArrayDeque<Character> characterSequence;
    private static HashMap<Character, double[]> characterCoordinate;
    
    public CharacterManager(){
        characterSequence = new ArrayDeque<Character>();
        characterCoordinate = new HashMap<Character, double[]>();

    }

    
}
