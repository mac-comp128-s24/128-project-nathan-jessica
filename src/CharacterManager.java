import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Random;

/**
 * 
 */
public class CharacterManager {
    private static ArrayDeque<Character> characterSequence;
    private static HashMap<Character, double[]> characterCoordinate;



    private static Random random = new Random();
    
    public CharacterManager(){
        characterSequence = new ArrayDeque<Character>();
        characterCoordinate = new HashMap<Character, double[]>();
    }

    public void placeCharacter(){
        
    }

    public double[] getCoordinate(Character character){
        return characterCoordinate.get(character);
    }

    public int randomInt(){
        return random.nextInt();
    }
}
