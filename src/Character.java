

/**
 * 
 */
public class Character {
    private static String pngPath;
    private static String name;
    private static CharacterManager manager;
    
    public Character(String path, String name, CharacterManager manager){
        this.pngPath = path;
        this.name = name;
        this.manager = manager;
    }

    private String getName(){
        return name;
    }

    private String getPath(){
        return pngPath;
    }

    private void setName(String name){
        this.name = name;
    }

    private void appear(){
        
    }

    private void clicked(){
        
    }

    private void checkQueue(){

    }
}
