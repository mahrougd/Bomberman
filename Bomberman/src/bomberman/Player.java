package bomberman;

public class Player {
    
    private int x, y;                   //Coordinated of player
    private final char id;              //id of player
    private final Tray tray;            //Tray with which is associated the player
    
    private int nbBombe = 1;            //Number of bomb which the player can put at the same time
    private int nbBombePoser = 0;       //Nomber of bomb already put
    private int vie = 1;                //Nomber of life of player
    private int puissanceBombe = 1;     //Powerful of bomb to the player
    
    
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
    
    
    /**Method allowing the travel of the player
     * @param direction 
     * z = haut, s = bas, q = gauche, d = droite*/
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
        tray.update();                                                  //We update
    }
    
    
    //Verify if the travel is valid
    private boolean validTravel(int newX, int newY){
        return tray.getBoardTray()[newY][newX].getComponent() != '#' && tray.getBoardTray()[newY][newX].getComponent() != 'c';
    }
    
    
    /**Allow to the player to put a bomb*/
    public void putBomb(){
        if(nbBombePoser < nbBombe){
            nbBombePoser ++;
            Bomb b = new Bomb(this, this.getX(), this.getY(), this.puissanceBombe);
            b.start();
        }
    }
    
    
    
    
    /***/
    public void bombeExploser(){
        nbBombePoser --;
    }
    
    
    /**Return the tray with which is associated the player
     * @return the tray associate to the player*/
    public Tray getTray(){
        return tray;
    }
    

    /**Return the id of the player
     * @return  number of the player*/
    public char getId(){
        return id;
    }
    
    
    /**Return the remaining life
     * @return remaining life*/
    public int getLife(){
        return vie;
    }
    
    
    /**Augmente la vie du joueur suite à un gain de vie*/
    public void gainVie(){
        vie ++;
    }
    
    
    /**Réduit la vie du joueur suite à un impacte d'une bombe*/
    public void perteVie(){
        vie --;
    }
    
    
    /**Augmente le nombre de bombe possable*/
    public void gainNbBombe(){
        nbBombe ++;
    }
    
    
    /**Augmente la puissance de la bombe*/
    public void gainPuissanceBombe(){
        puissanceBombe ++;
    }
    
}