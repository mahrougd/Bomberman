package fr.iutinfo.bomberman.resources;
import fr.iutinfo.bomberman.models.*;
public class Cell {
    
    private char state = ' ';   //What contains the cell
    private Player player;      //Present player in the cell
    
    
    public Cell(){}
    
    
    /**Add an obstacle in the cell*/
    public void addObstacle (){
        state = '#';
    }
    
    
    /**Add a box in the cell*/
    public void addBox(){
        state = 'c';
    }
    
    
    /**Insert a bomb in the cell*/
    public void addBomb(){
        state = 'B';
    }
    
    
    /**Return the component in the cell
     * @return  'P' for a powerful bonus
                'N' for a number bonus
                ' ' for a empty cell
                'B' for a bomb
                '1' for the player 1
                '2' for the player 2*/
    public char getComponent(){
        return state;
    }
    
    
    /**Add a plyer in the cell
     * @param player Player to add to the cell*/
    public void addPlayer(Player player){
        //We test at first if the cell contains a bonus
        if(state == 'P')
            player.gainBombPowerful();
        if(state == 'N')
            player.gainBombNb();
        
        this.player = player;
        state = this.player.getId();
    }
    
    
    /**Return the player on the cell
     * @return player or null*/
    public Player getPlayer(){
        return player;
    }
    
    
    /**Clean the cell*/
    public void cleanCell(){
        player = null;
        state = ' ';
    }
    
    
    /**Clean the cell according to what is here, if there are bonus 
     * or obstacle, the cell isn't clean*/
    public void update(){
        if(state != '#' && state != 'N' && state != 'P')
            state = ' ';
    }
    
    
    /**Allow to blown up the bom
     * @param dir Direction of the explosion*/
    public void blownUpBomb(char dir){
        if(state != '#'){
            if(state == 'c')
                explodeBox();
            else if(state == '1' || state == '2'){
                if(player != null)
                    player.perteVie();
            } else
                state = dir;
        }
    }
    
    
    /**Choose random the component of a box */
    private void explodeBox(){
        switch((int)(Math.random() * 3)){
            case 0:
                state = 'P';
                break;
            case 1:
                state = 'N';
                break;
            case 2:
                state = ' ';
                break;
        }
    } 
    
}
