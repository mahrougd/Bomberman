package fr.iutinfo.bomberman.resources;

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
            obstacle = ImageIO.read(this.getClass().getResourceAsStream("../resources/Obstacle.png"));
            player = ImageIO.read(this.getClass().getResourceAsStream("../resources/Player.png"));
            bomb = ImageIO.read(this.getClass().getResourceAsStream("../resources/Bomb.png"));
            flame1 = ImageIO.read(this.getClass().getResourceAsStream("../resources/Flame1.png"));
            flame2 = ImageIO.read(this.getClass().getResourceAsStream("../resources/Flame2.png"));
            flame3 = ImageIO.read(this.getClass().getResourceAsStream("../resources/Flame3.png"));
            box = ImageIO.read(this.getClass().getResourceAsStream("../resources/Box.png"));
            powerful = ImageIO.read(this.getClass().getResourceAsStream("../resources/BonusPowerful.png"));
            number = ImageIO.read(this.getClass().getResourceAsStream("../resources/BonusBomb.png"));
        }catch (IOException e) {
            System.out.println("The image was not able to be read");
        }
    }
    
}
