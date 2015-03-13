package bomberman;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
    private final Joueur joueur1;
    private final Joueur joueur2;
    private final Plateau plateau;
    
    public GameWindow(){
        this.setSize(1200, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        
        plateau = new Plateau();
	joueur1 = new Joueur(plateau,1,1,1);
        joueur2 = new Joueur(plateau,17,9,2);
	plateau.addJoueur(joueur1);
        plateau.addJoueur(joueur2);
        plateau.affichePlateau();
        this.getContentPane().add(plateau);
        
        this.setVisible(true);
    }
    
}
