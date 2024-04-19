import edu.macalester.graphics.CanvasWindow;

/**
 * 
 */
public class MemoryGame {
    private static CharacterManager charManager;
    private static InputManager inputManager;

    private static Levels levels;
    private static int currentLevel;

    private static int lifeLeft;


    public MemoryGame(CanvasWindow window){
        charManager = new CharacterManager(window);
        inputManager = new InputManager(window, charManager);
        levels = new Levels();
        currentLevel = 1;

        charManager.placeCharacter();

        window.onMouseDown(event -> inputManager.memoryClick(event.getPosition()));
    }


}
