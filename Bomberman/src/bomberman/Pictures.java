package bomberman;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pictures {

    public static Image ground;
    public static Image obstacle;
    public static Image player;
    public static Image bomb;
    public static Image flame;
    public static Image box;
    public static Image powerful;
    public static Image number;
    
    
    /**The builder will load the images that we need for our game*/
    public Pictures (){
        try{
            ground = ImageIO.read(this.getClass().getResourceAsStream("ground.png"));
            obstacle = ImageIO.read(this.getClass().getResourceAsStream("obstacle.jpg"));
            player = ImageIO.read(this.getClass().getResourceAsStream("player.png"));
            bomb = ImageIO.read(this.getClass().getResourceAsStream("bomb.png"));
            flame = ImageIO.read(this.getClass().getResourceAsStream("flame.jpg"));
            box = ImageIO.read(this.getClass().getResourceAsStream("box.png"));
            powerful = ImageIO.read(this.getClass().getResourceAsStream("powerful.jpg"));
            number = ImageIO.read(this.getClass().getResourceAsStream("number.jpg"));
        }catch (IOException e) {
            System.out.println("The image was not able to be read");
        }
    }
}
