import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Queue;

/**
 * 
 */
public class CharacterManager {
    private static Queue<Character> characterSequence;
    private static HashMap<Character, double[]> characterCoordinate;



    private static Random random = new Random();
    
    public CharacterManager(){
        characterSequence = new LinkedList<>();
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
