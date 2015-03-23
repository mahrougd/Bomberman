package bomberman;

public class Player {
    
    private int x, y;                   //Coordinated of player
    private final char id;              //id of player
    private final Tray tray;            //Tray with which is associated the player
    
    private int bombNb = 1;            //Number of bomb which the player can put at the same time
    private int BombNbPut = 0;       //Nomber of bomb already put
    private int life = 1;                //Nomber of life of player
    private int bombPowerful = 1;     //Powerful of bomb to the player
    
    
    /**@param tray Tray with which is associated the player
     * @param x Coordinated x of the player
     * @param y Coordinated y of the player
     * @param id id of player*/
    public Player(Tray tray, int x, int y, char id){
        this.tray = tray;
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
 
    /**Return the coordinated x
     * @return  coordinated x of player*/
    public int getX(){
        return this.x;
    }
    
    
    /**Return the coordinated y
     * @return  coordinated y of player*/
    public int getY(){
        return this.y;
    }
    

    /**Return the id of the player
     * @return  number of the player*/
    public char getId(){
        return id;
    }
    
    
    /**Return the tray with which is associated the player
     * @return the tray associate to the player*/
    public Tray getTray(){
        return tray;
    }
    
    
    /**Return the remaining life
     * @return remaining life*/
    public int getLife(){
        return life;
    }
    
    
    /**Increases the player life*/
    public void gainVie(){
        life ++;
    }
    
    
    /**Degreases the player life*/
    public void perteVie(){
        life --;
    }
    
    
    /**Method allowing the travel of the player
     * @param direction 
     * z = up, s = down, q = left, d = right*/
    public void move(char direction){
        int posX = this.getX();
        int posY = this.getY();
        switch (direction){
            case 'd':
                if(validTravel(x+1, y))
                    x++;
                break;
            case 'q':
                if(validTravel(x-1, y))
                    x--;
                break;
            case 'z':
                if(validTravel(x, y-1))
                    y--;
                break;
            case 's':
                if(validTravel(x, y+1))
                    y++;
                break;
        }
        if(tray.getBoardTray()[posY][posX].getComponent() != 'B')
            tray.getBoardTray()[posY][posX].cleanCell();                //Remove the player to his position
        tray.getBoardTray()[this.getY()][this.getX()].addPlayer(this);  //move the player on his new position
        tray.update();                   
    }
    
    
    //Verify if the travel is valid
    private boolean validTravel(int newX, int newY){
        return tray.getBoardTray()[newY][newX].getComponent() != '#' && tray.getBoardTray()[newY][newX].getComponent() != 'c'
                && tray.getBoardTray()[newY][newX].getComponent() != 'B';
    }
    
    
    /**Allow to the player to put a bomb*/
    public void putBomb(){
        if(BombNbPut < bombNb){
            BombNbPut ++;
            Bomb b = new Bomb(this, this.getX(), this.getY(), this.bombPowerful);
            b.start();
        }
    }
    
    
    /**Decreases the number of bomb that the player have put*/
    public void bombExplosed(){
        BombNbPut --;
    }
    
    
    /**Increases the number of bomb that the player can put*/
    public void gainBombNb(){
        bombNb ++;
    }
    
    
    /**Increases the powerful of bombs*/
    public void gainBombPowerful(){
        bombPowerful ++;
    }
    
}