package bomberman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.Image.*;

/**This class corresponds to the display of a cell*/
public class PicturesPanel extends JPanel {

    private int choice;
    private Image i = null;
   
    
    public PicturesPanel(int choice){
        this.choice = choice;
        
    }
    

    /**Allow to change the image
     * @param i int which corresponds to the image chosen*/
    public void setImage(int i){
        choice = i;
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        switch (choice){
            case 1:
                i = null;
                //i = Pictures.ground;
                break;
            case 2:
                i = Pictures.obstacle;
                break;
            case 3:
                i = Pictures.player;
                break;
            case 4:
                i = Pictures.bomb;
                break;
            case 5:
                i = Pictures.flame1;
                break;
            case 6:
                i = Pictures.flame2;
                break;
            case 7:
                i = Pictures.flame3;
                break;
            case 8:
                i = Pictures.box;
                break;
            case 9:
                i = Pictures.powerful;
                break;
            case 10:
                i = Pictures.number;
                break;
        }
        g2d.setBackground(new Color(0, 121, 60));
        g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
        if(i != null)
            g2d.drawImage(i, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
}