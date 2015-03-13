package bomberman;

public class Cellule {
    
    private String etat = " ";      //Etat de la cellule
    private Joueur joueur;          //Joueur présent sur la cellule
    public Cellule(){}
    
    
    /**Ajoute un obstacle dans la cellule*/
    public void addObstacle(){
        etat = "#";
    }
    
    
    public void addCaisse(){
        etat = "c";
    }
    
    
    /**Ajoute un joueur sur la cellule
     * @param joueur*/
    public void addJoueur(Joueur joueur){
        this.joueur = joueur;
        etat = this.joueur.toString();
    }
    
    
    public Joueur getJoueur(){
        return joueur;
    }
    
    
    /**Vide la case*/
    public void videCase(){
        joueur = null;
        etat = " ";
    }
    
    
    /**Insert une bombe sur la case
     * @param puissance*/
    public void poserBombe(int puissance){
        etat = "B";
    }
    
    
    public void verifExplosion(){
        if(!etat.equals("#")){
            if(etat.equals("c"))
                insertObject();
            else {
                if(joueur != null)
                    joueur.perteVie();
                etat = "F";
            }
        }
    }
    
    
    public void insertObject(){
        int i = (int)(Math.random() * 3);
        if(i == 0)
            etat = "P";
        else if(i == 1)
            etat = "N";
        else
            etat = " ";
    }
    
    
    public void resetEtat(){
        if(!etat.equals("#") && !etat.equals("N") && !etat.equals("P"))
            etat = " ";
    }
    
    
    @Override
    public String toString(){
        return etat;
    }
}
