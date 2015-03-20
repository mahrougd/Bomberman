package bomberman;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**This class create a new process allow to manage a bomb*/
public class Bomb extends Thread {

    private final Tray tray;
    private final int x;
    private final int y;
    private final int powerful;
    private final Player player;


    /**@param player Player who has put the bomb
     * @param x Coordinates x of the bomb
     * @param y Coordinates y of the bomb
     * @param powerful Powerful of the bomb*/
    public Bomb(Player player, int x, int y, int powerful){
        this.tray = player.getTray();
        this.x = x;
        this.y = y;
        this.powerful = powerful;
        this.player = player;
    }


    @Override
    public void run() {
        tray.getBoardTray()[y][x].addBomb();
        
        //The bomb puts a time of three seconds before exploding
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bomb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //The bomb explodes and causes damages on the boxs contained in this array
        ArrayList <Cell> cells = new ArrayList<>();
        cells.add(tray.getBoardTray()[y][x]);
        tray.getBoardTray()[y][x].blownUpBomb('z');
        for(int a = y - 1; a >= (y - powerful); a--){
            if(a >= 0){ 
                if(!estCaisseObstacle(x, a)){
                    tray.getBoardTray()[a][x].blownUpBomb('y');
                    cells.add(tray.getBoardTray()[a][x]);
                } else {
                    tray.getBoardTray()[a][x].blownUpBomb('y');
                    cells.add(tray.getBoardTray()[a][x]);
                    break;
                }
            }
        }
        
        for(int b = y + 1; b <= (y + powerful) ; b++){
            if(b < tray.getBoardTray().length){ 
                if(!estCaisseObstacle(x, b)){
                    tray.getBoardTray()[b][x].blownUpBomb('y');
                    cells.add(tray.getBoardTray()[b][x]);
                } else {
                    tray.getBoardTray()[b][x].blownUpBomb('y');
                    cells.add(tray.getBoardTray()[b][x]);
                    break;
                }
            }
        }
        
        for(int d = x - 1; d >= (x - powerful) ; d--){
            if(d >= 0){
                if(!estCaisseObstacle(d, y)){
                    tray.getBoardTray()[y][d].blownUpBomb('x');
                    cells.add(tray.getBoardTray()[y][d]);
                } else {
                    tray.getBoardTray()[y][d].blownUpBomb('x');
                    cells.add(tray.getBoardTray()[y][d]);
                    break;
                }
            }
        }
        
        for(int e = x + 1; e <= (x + powerful) ; e++){
            if(e < tray.getBoardTray()[0].length){
                if(!estCaisseObstacle(e, y)){
                    tray.getBoardTray()[y][e].blownUpBomb('x');
                    cells.add(tray.getBoardTray()[y][e]);
                } else {
                    tray.getBoardTray()[y][e].blownUpBomb('x');
                    cells.add(tray.getBoardTray()[y][e]);
                    break;
                }
            }
        }
        
        //We update
            tray.update();       
        
        //The hard explosion 1/2 seconde
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bomb.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //We update
            for(Cell cel : cells)
                cel.update();
            
            tray.update();
            player.bombExplosed();
    }
    
    public boolean estCaisseObstacle(int x, int y){
        return tray.getBoardTray()[y][x].getComponent() == 'c' || tray.getBoardTray()[y][x].getComponent() == '#';
    }
    
}
