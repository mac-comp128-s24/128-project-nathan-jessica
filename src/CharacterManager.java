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
    private static double timer = 1;

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

        character.setMaxHeight(randomSize());
        character.setPosition(randomCoordinate());
        characterSequence.offer(character);
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
        if(characterSequence != null){
        window.remove(characterSequence.peek());
        characterSequence.poll();
        }
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

    private void placeTimer(){
        for(Character hero: characterSequence){
            placeCharacter();
            window.animate((dt) -> {
                if (characterPlaced(hero) == true) {
                    timer -= dt;
                }
            });
            if(timer != 0){
                break;
            }
        }
    }

    public Queue<Character> getCharacterSequence(){
        return characterSequence;
    }
}
