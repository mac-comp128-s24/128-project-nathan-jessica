import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Collections;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.util.Queue;

/**
 * 
 */
public class CharacterManager {
    private static Queue<Character> characterSequence;
    private static HashMap<Character, double[]> characterCoordinate;

    private CanvasWindow window;
    private Levels levels;
    private static CharacterPNGPath pathDirectory;
    private long timer = 1;

    private int currentLevel;

    private static Random random = new Random();

    private static final int MIN_SIZE = 100;
    private static final int MAX_SIZE = 200;
    
    public CharacterManager(CanvasWindow window){
        characterSequence = new LinkedList<>();
        characterCoordinate = new HashMap<Character, double[]>();
        pathDirectory = new CharacterPNGPath();
        this.window = window;
        this.levels = new Levels();
    }

    public void setCurrentLevel(int level){
        this.currentLevel = level;
    }

    public void placeCharacter(){
        String[] characterAvailable = levels.get(currentLevel);
        int characterIndex = randomInt(characterAvailable.length);
        //DEBUG
        System.out.println(characterIndex);
        //DEBUG END
        
        String characterName = characterAvailable[characterIndex];
        //DEBUG
        System.out.println(characterName);
        //DEBUG END
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

        characterSequence.offer(character);
        characterCoordinate.put(character, coordinateRange);
    }

    private boolean characterPlaced(Character character){
        if(characterSequence.peek() != null){
            return true;
        }
        else{
            return false;
        }
    }

    public void removeCharacter(){
        if (!characterSequence.isEmpty()) {
            window.remove(characterSequence.peek());
            characterSequence.poll();
        }
    }

    private double[] getCoordinate(Character character){
        double[] coordinate = characterCoordinate.get(character).clone();
        return coordinate;
    }

    public double[] getFirstCharacterCoordinate(){
        return getCoordinate(characterSequence.peek()).clone();
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
    
    public Queue<Character> getCharacterSequence(){
        return characterSequence;
    }
}
