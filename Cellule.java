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
    
    
    public Joueur getJoueur(){
        return joueur;
    }
    
    
    public void verifExplosion(){
        if(!etat.equals("#")){
            if(joueur != null)
                joueur.perteVie();
            etat = "F";
        }
    }
    
    
    public void resetEtat(){
        if(!etat.equals("#"))
            etat = " ";
    }
    
    
    @Override
    public String toString(){
        return etat;
    }
}
