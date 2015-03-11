package bomberman;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
    
    public Fenetre(){
        this.setSize(1200, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        
        Plateau plateau = new Plateau();
        Joueur joueur = new Joueur(plateau);
        plateau.addJoueur(joueur);
        this.getContentPane().add(plateau);
        
        this.setVisible(true);
    }
    
}
