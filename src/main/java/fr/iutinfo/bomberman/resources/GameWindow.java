package fr.iutinfo.bomberman.resources;
import fr.iutinfo.bomberman.models.*;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
    private final Player player1;
    private final Player player2;
    private final Tray tray;
    
    public GameWindow(){
        this.setSize(1170, 705);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        
        tray = new Tray();
        
	player1 = new Player(tray,1,1,'1');
        player2 = new Player(tray,17,9,'2');
	tray.addPlayer(player1);
        tray.addPlayer(player2);
        
        tray.displayTray();
        this.getContentPane().add(tray);
        
        this.setVisible(true);
    }
    
}
