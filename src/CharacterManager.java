import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.util.Queue;

/**
 * 
 */
public class CharacterManager {
    private static Queue<Character> characterSequence;
    private static CharacterPNGPath characterPathMap;
    private static HashMap<Character, double[]> characterCoordinate;

    private CanvasWindow window;
    private Levels levels;
    private static CharacterPNGPath pathDirectory;

    private int currentLevel;

    private static Random random = new Random();

    private static final int MIN_SIZE = 50;
    private static final int MAX_SIZE = 100;
    
    public CharacterManager(CanvasWindow window){
        characterSequence = new LinkedList<>();
        characterPathMap = new CharacterPNGPath();
        characterCoordinate = new HashMap<Character, double[]>();
        pathDirectory = new CharacterPNGPath();
        this.window = window;
        this.levels = new Levels();
    }

    public void setCurrentLevel(int level){
        this.currentLevel = level;
    }

    public void placeCharacter(){
        String[] characterAvailable = Levels.get(currentLevel);
        int characterIndex = randomInt(characterAvailable.length);
        String characterName = characterAvailable[characterIndex];
        Character character = new Character(pathDirectory.get(characterName), characterName);
        
        character.setMaxHeight(randomSize());
        character.setPosition(randomCoordinate());
        window.add(character);
        characterSequence.offer(character);
    }

    private double[] getCoordinate(Character character){
        return characterCoordinate.get(character);
    }

    private int randomInt(int limit){
        return random.nextInt(limit);
    }
    
    private int randomInt(int lowerLimit, int upperLimit){
        return random.nextInt(lowerLimit, upperLimit);
    }

    private int randomSize(){
        return randomInt(MIN_SIZE, MAX_SIZE);
    }

    private Point randomCoordinate(){
        return new Point(randomInt(window.getWidth()-MIN_SIZE), randomInt(window.getHeight()-MIN_SIZE));
    }
    
    public double[] getFirstCharacterCoordinate(){
        return getCoordinate(characterSequence.peek());
    }
}
