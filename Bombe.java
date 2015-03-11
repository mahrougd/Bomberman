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
        try {
            Thread.sleep(3000);
            System.out.println("EXPLOSION!!!!!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Bombe.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Cellule c : tabCel)
            c.verifExplosion();
        cel.videCase();
        plateau.update(" ");
        for(Cellule c : tabCel)
            c.resetEtat();
        plateau.update(" ");
    }
    
}
