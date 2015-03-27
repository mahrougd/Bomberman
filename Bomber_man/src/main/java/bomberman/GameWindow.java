package bomberman;

public class GameWindow extends Thread {
	
    private final Player player1;
    private final Player player2;
    private final Tray tray;
    private boolean gameOver = false;
    
    public GameWindow(){
        
        tray = new Tray();
        
	player1 = new Player(tray,1,1,'1');
        player2 = new Player(tray,17,9,'2');
	tray.addPlayer(player1);
        tray.addPlayer(player2);
        
        tray.displayTray();
    }
    
    public String getTray(){
        if(gameOver())
            return "end";
        return tray.toString();
    }
    
    public boolean gameOver(){
        if(tray.toString().equals("end"))
            gameOver = true;
        return gameOver;
    }
    
    public void up(int p){
        if(p == 1)
            player1.move('z');
        else
            player2.move('z');
    }
    
    public void down(int p){
        if(p == 1)
            player1.move('s');
        else
            player2.move('s');
    }
    
    public void left(int p){
        if(p == 1)
            player1.move('q');
        else
            player2.move('q');
    }
    
    public void right(int p){
        if(p == 1)
            player1.move('d');
        else
            player2.move('d');
    }
    
    public void bomb(int p){
        if(p == 1)
            player1.putBomb();
        else
            player2.putBomb();
    }
    
    @Override
    public void run(){
        while(!gameOver){
            tray.update();
        }
    }
    
}
