package bomberman;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**This class allow to load all images*/
public class Pictures {

    public static Image obstacle;
    public static Image player;
    public static Image bomb;
    public static Image flame1;
    public static Image flame2;
    public static Image flame3;
    public static Image box;
    public static Image powerful;
    public static Image number;
    
    
    /**The builder will load the images that we need for our game*/
    public Pictures (){
        try{
            obstacle = ImageIO.read(this.getClass().getResourceAsStream("../Images/Obstacle.png"));
            player = ImageIO.read(this.getClass().getResourceAsStream("../Images/Player.png"));
            bomb = ImageIO.read(this.getClass().getResourceAsStream("../Images/Bomb.png"));
            flame1 = ImageIO.read(this.getClass().getResourceAsStream("../Images/Flame1.png"));
            flame2 = ImageIO.read(this.getClass().getResourceAsStream("../Images/Flame2.png"));
            flame3 = ImageIO.read(this.getClass().getResourceAsStream("../Images/Flame3.png"));
            box = ImageIO.read(this.getClass().getResourceAsStream("../Images/Box.png"));
            powerful = ImageIO.read(this.getClass().getResourceAsStream("../Images/BonusPowerful.png"));
            number = ImageIO.read(this.getClass().getResourceAsStream("../Images/BonusBomb.png"));
        }catch (IOException e) {
            System.out.println("The image was not able to be read");
        }
    }
    
}
