package bomberman;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Bombe extends Thread {
    
    private final Cellule cel;
    private final Plateau plateau;
    private final Cellule[] tabCel;
    
    
    public Bombe(Cellule cel, Plateau plateau, Cellule[] tabCel){
        this.cel = cel;
        this.plateau = plateau;
        this.tabCel = tabCel;
    }
    
    
    @Override
    public void run() {
        //The bomb puts a time of three seconds before exploding
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bombe.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //The bomb explodes and causes damages on the boxs contained in this array
            for(Cellule c : tabCel)
                c.verifExplosion();
        
        //On vide la case du joueur
            cel.videCase();
        //We update
            plateau.update();       
        
        //The hard explosion 1/2 seconde
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bombe.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //We update
            for(Cellule c : tabCel)
                c.resetEtat();
            plateau.update();
    }
    
}
