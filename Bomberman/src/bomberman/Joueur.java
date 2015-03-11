package bomberman;

public class Joueur {
    
    private int x = 1;                          //Coordonnées x du joueur
    private int y = 1;                          //Coordonnées y du joueur
    private final Plateau plateau;              //Plateau auquel est associé le joueur
    private boolean joueurPoseBombe = false;    //Booléen pour savoir si le joueur peut encore posser une bombe
    private int nbBombe;                        //Nombre de bombe que le joueur peut poser à la fois
    private int nbBombePoser = 0;               //Nombre de bombe déjà poser
    private int vie = 1;                        //Nombre de vie du joueur
    private int puissanceBombe = 1;
    
    /**Association du joueur au plateau
     * @param plateau*/
    public Joueur(Plateau plateau){
        this.plateau = plateau;
    }
    
    
    /**Retourne les coordonnées du joueur sous forme d'un tableau
     * @return [x, y]
     */
    public int[] getCoordonnees(){
        return new int[]{x, y};
    }
    
    
    /**Méthode permettant le déplacement du joueur
     * @param direction 
     z = haut, s = bas, q = gauche, d = droite*/
    public void deplacement(String direction){
        int posX = this.getCoordonnees()[0];
        int posY = this.getCoordonnees()[1];
        if (direction.equals("d") &&  plateau.getPlateau()[y][x+1].toString().equals(" "))
            x++;
        if (direction.equals("q") &&  plateau.getPlateau()[y][x-1].toString().equals(" "))
            x--;
        if (direction.equals("z") &&  plateau.getPlateau()[y-1][x].toString().equals(" "))
            y--;
        if (direction.equals("s") &&  plateau.getPlateau()[y+1][x].toString().equals(" "))
            y++;
        
        if(joueurPoseBombe){
            poserBombe(posX, posY);
            poserBombe(false);
        }
        else
            plateau.getPlateau()[posY][posX].videCase();
        plateau.update("J");
    }
    
    
    /**Methode permetant de demander l'insertion d'une bombe sur les coordonnées x et y
     * @param x
     * @param y*/
    public void poserBombe(int x, int y){
        nbBombePoser ++;
        Cellule[] c = new Cellule[puissanceBombe * 4];
        int indice = 0;
        for(int a = y - puissanceBombe; a < y + puissanceBombe + 1; a++){
            if(a != y){
                c[indice] = plateau.getPlateau()[a][x];
                indice++;
            }
        }
        for(int b = x - puissanceBombe; b < x + puissanceBombe + 1; b++){
            if(b != x){
                c[indice] = plateau.getPlateau()[y][b];
                indice++;
            }
        }
        plateau.getPlateau()[y][x].poserBombe(this.puissanceBombe);
        Bombe b = new Bombe(this.plateau.getPlateau()[y][x], this.plateau, c);
        b.start();
    }
    
    
    /*Permet de savoir si le joueur veux poser une bombe*/
    public void poserBombe(boolean b){
        joueurPoseBombe = b;
    }
    
    
    /**Retourne la vie restante du joueur
     * @return vie*/
    public int getVie(){
        return vie;
    }
    
    
    /**Augmente la vie du joueur suite à un gain de vie*/
    public void gainVie(){
        vie ++;
    }
    
    
    /**Réduit la vie du joueur suite à un impacte d'une bombe*/
    public void perteVie(){
        vie --;
        if(vie < 0)
            System.out.println("mort!");
    }
    
    
    /**Augmente le nombre de bombe possable*/
    public void gainBombe(){
        nbBombe ++;
    }
    
    
    /**Augmente la puissance de la bombe*/
    public void gainPuissanceBombe(){
        puissanceBombe ++;
    }
    
    
    @Override
    public String toString(){
        return "J";
    }
    
}
