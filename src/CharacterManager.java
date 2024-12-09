import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

/**
 * Manages our characters through adding and removing characters from our initialized data structures
 * Smaller methods allows us to manage what the user sees on the canvas with the characters
 * @author Yunzhu (Jessica) Chen
 * @author Nathan Gumagay
 * COMP 128 SPRING 2024
 */
public class CharacterManager {
    private static Queue<Character> characterSequence;
    private static HashMap<Character, double[]> characterCoordinate;

    private CanvasWindow window;
    private Levels levels;
    private static CharacterPNGPath pathDirectory;

    private int currentLevel;

    private static Random random = new Random();

    private static final int MIN_SIZE = 300;
    private static final int MAX_SIZE = 400;
    private static final int PADDING = 100;
    

    /**
     * Creates a new Character Manager with the canvas window argument
     * Creates a Queue, Hashmap, as well as initializes the Character's path
     * Creates the level and initializes the window
     * @param window
     */
    public CharacterManager(CanvasWindow window){
        characterSequence = new LinkedList<>();
        characterCoordinate = new HashMap<Character, double[]>();
        pathDirectory = new CharacterPNGPath();
        this.window = window;
        this.levels = new Levels();
    }

    /**
     * set the level with the argument
     */
    public void setCurrentLevel(int level){
        this.currentLevel = level;
    }

    /**
     * Adds the character to the canvas window, adds the character to the queue, and adds the character to the hashmap
     */
    public void placeCharacter(){
        String[] characterAvailable = levels.get(currentLevel);
        int characterIndex = randomInt(characterAvailable.length);
        
        String characterName = characterAvailable[characterIndex];
        Character character = new Character(pathDirectory.get(characterName), characterName);
        
        window.add(character);

        int size = randomSize();
        Point coordinate = randomCoordinate();

        character.setMaxHeight(size);
        character.setPosition(coordinate);

        double minX = (double) coordinate.getX();
        double maxX = coordinate.getX() + character.getWidth();
        double minY = (double) coordinate.getY();
        double maxY = coordinate.getY() + character.getHeight();
        
        double[] coordinateRange = {minX, maxX, minY, maxY};
        for (double coordinatePoint : coordinateRange){
        }

        characterSequence.offer(character);
        characterCoordinate.put(character, coordinateRange);
    }

    /**
     * removes the character from the window as well as the character from the queue
     */
    public void removeCharacter(){
        if (!characterSequence.isEmpty()) {
            window.remove(characterSequence.peek());
            characterSequence.poll();
        }
    }

    /**
     * @return the coordinate of the character that was the argument
     * @param character
     */
    private double[] getCoordinate(Character character){
        double[] coordinate = characterCoordinate.get(character).clone();
        return coordinate;
    }

    /**
     * @return the coordinates of our character
     */
    public double[] getFirstCharacterCoordinate(){
        return getCoordinate(characterSequence.peek()).clone();
    }

    /**
     * @return a random int for the limit
     * @param limit
     */
    private int randomInt(int limit){
        return random.nextInt(limit);
    }
    
    /**
     * @return a random integer for the lower limit and upper limit
     * @param lowerLimit
     * @param upperLimit
     */
    private int randomInt(int lowerLimit, int upperLimit){
        return random.nextInt(lowerLimit, upperLimit);
    }

    /**
     * @return a random integer that will be the size of our image
     */
    private int randomSize(){
        return randomInt(MIN_SIZE, MAX_SIZE);
    }

    /**
     * @return a random point on our canvas window
     */
    private Point randomCoordinate(){
        return new Point(randomInt(PADDING, window.getWidth()-MIN_SIZE-PADDING), randomInt(PADDING, window.getHeight()-MIN_SIZE-PADDING));
    }
    
    /**
     * @return a queue of characters
     */
    public Queue<Character> getCharacterSequence(){
        return characterSequence;
    }
}
