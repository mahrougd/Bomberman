package bomberman;

public class Load {
    
    public static GameWindow B = new GameWindow();
    public static int id = 1;

    
    public void incId(){
        id++;
    }
    
    public void newGame(){
        B = new GameWindow();
    }
}
