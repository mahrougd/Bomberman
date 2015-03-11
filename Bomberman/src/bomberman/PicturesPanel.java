package bomberman;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Image.*;

public class PicturesPanel extends JPanel {

    int img;
    
    public PicturesPanel(int img){
        this.setBackground(Color.red);
        this.img = img;
    }
    
    @Override
    public void paintComponent(Graphics g){
        MediaTracker mediaTracker = new MediaTracker(this);                                 //Permet de suivre des objet spécifique
        try {
            Image i = null;
            if(img == 1)
                i = ImageIO.read(this.getClass().getResourceAsStream("sol.gif"));           //On ajoute une image
            if(img == 2)
                i = ImageIO.read(this.getClass().getResourceAsStream("obstacle.jpg"));      //On ajoute une image
            if(img == 3)
                i = ImageIO.read(this.getClass().getResourceAsStream("joueur.png"));        //On ajoute une image
            if(img == 4)
                i = ImageIO.read(this.getClass().getResourceAsStream("bombe.gif"));         //On ajoute une image
            if(img == 5)
                i = ImageIO.read(this.getClass().getResourceAsStream("flamme.jpg"));        //On ajoute une image
            if(img == 6)
                i = ImageIO.read(this.getClass().getResourceAsStream("Caisse.png"));        //On ajoute une image
            mediaTracker.addImage(i, 0);                                                    //On ajoute l'image au traceur avec un identifiant
            mediaTracker.waitForAll();                                                      //Demare le chargement de toutes les images suivit par ce traceur
            g.drawImage(i, 0, 0, this.getWidth(), this.getHeight(), this);                  //On affiche l'image            
        } catch (IOException e1) {                                                          //Test si l'image à été lu correctement
            System.out.println("L'image n'a pas pu etre lu");
        } catch (InterruptedException e) {                                                  //Test si le traceur ne rencontre pas de probleme
            System.out.println("Le traceur à rencontrer un probleme");
        }
    }
    
}