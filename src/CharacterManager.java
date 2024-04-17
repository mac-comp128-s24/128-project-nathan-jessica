import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;

import java.util.Queue;

/**
 * 
 */
public class CharacterManager {
    private static Queue<Character> characterSequence;
    private static CharacterPNGPath characterPathMap;
    private static HashMap<Character, double[]> characterCoordinate;

    private static CanvasWindow window;
    private static Levels levels;

    private static int currentLevel;

    private static Random random = new Random();
    
    public CharacterManager(CanvasWindow window, Levels levels){
        characterSequence = new LinkedList<>();
        characterPathMap = new CharacterPNGPath();
        characterCoordinate = new HashMap<Character, double[]>();
        this.window = window;
        this.levels = levels;
    }

    public void setCurrentLevel(int level){
        this.currentLevel = level;
    }

    public void placeCharacter(){
        String[] characterAvailable = levels.get(currentLevel);
        int characterIndex = randomInt(characterAvailable.length);
        Character character = new Character(null, characterAvailable[characterIndex], this);
    }

    private double[] getCoordinate(Character character){
        return characterCoordinate.get(character);
    }

    private int randomInt(int limit){
        return random.nextInt(limit);
    }

    
    public double[] getFirstCharacterCoordinate(){
        return getCoordinate(characterSequence.peek());
    }
}
