package bomberman;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public final class Plateau extends JPanel implements KeyListener {
    
    private final Cellule[][] cellule;          //Tableau sous forme de cellule
    private final GridBagConstraints gbc;       //Permet de gerer le grid bag layout
    private Joueur joueur;                      //Liste des joueurs sur le plateau
    PicturesPanel pi;                           //Panel permettant d'afficher les image (à remove)
    
    
    /**Initialise le plateau*/
    public Plateau(){
        gbc = new GridBagConstraints();                 //
        gbc.gridx = 1;                                  //
        gbc.gridy = 1;                                  //
        gbc.gridwidth = 1;                              //
        gbc.gridheight = 1;                             //
        gbc.weightx = 100;                              //
        gbc.weighty = 100;                              //Définit les contraintes du grid bag layout
        gbc.fill = GridBagConstraints.NONE;             //
        gbc.anchor = GridBagConstraints.NORTHWEST;      //
        gbc.insets = new Insets(0,0,0,0);               //
        gbc.ipadx = 50;                                 //
        gbc.ipady = 50;                                 //
        
        this.setLayout(new GridBagLayout());            //Ajout du grid bag layout
        addKeyListener(this);                           //Ajout du key listener
        
        cellule = new Cellule[11][19];                    //Initialisation de la taille du plateau
        
        //Initialisation des obstacles au bord du plateau
        for(int i = 0; i < cellule.length; i++){
            for(int j = 0; j < cellule[0].length; j++){
                cellule[i][j] = new Cellule();
                /*if(i == 0 || i == cellule[0].length-1 || j == 0 || j == cellule.length-1)
                    cellule[i][j].addObstacle();*/
            }
        }
        createTab();
        
        //Initialisation des obstacles à l'intérieur du plateau
        /*for(int a = 0; a < cellule[0].length; a = a + 2){
            for(int b = 0; b < cellule.length; b = b + 2){
                cellule[a][b].addObstacle();
            }
        }*/
    }
    
    
    /**19 11*/
    public void createTab(){
        int t = (int)(Math.random() * 5) + 1;
        String tab = "";
        int indice = 0;
        switch(t){  
            case 1 :
                tab = "###################"
                    + "#    c    c cc c  #"
                    + "#c#c# #c# #c# #c# #"
                    + "#      c     c   c#"
                    + "#c# #c# # #c#c# # #"
                    + "#    c     c     c#"
                    + "#c#c# #c#c# # #c#c#"
                    + "#c c     c c   c  #"
                    + "# #c# # #c#c#c# # #"
                    + "#   c    c  c  c  #"
                    + "###################";
                break;
            case 2 :
                tab = "###################"
                    + "#    c  ccc c     #"
                    + "#c# # #c#c#c# #c# #"
                    + "#  c   c     c   c#"
                    + "#c# #c# # #c#c# # #"
                    + "#    c  cc c     c#"
                    + "#c#c# #c#c# # #c# #"
                    + "#c c   c     c   c#"
                    + "#C# # #c# # #c# #c#"
                    + "#    ccccccc      #"
                    + "###################";
                break;
            case 3 :
                tab = "###################"
                    + "#  c  c  cc c     #"
                    + "# #c# #c#c#c# #c# #"
                    + "#c c   c c c   c c#"
                    + "#c# #c# # #c#c# # #"
                    + "#    c     c     c#"
                    + "#c#c# #c#c#c# #c# #"
                    + "#c c c c c c c c c#"
                    + "#C# # #c# # #c# #c#"
                    + "#    c c cc      #"
                    + "###################";
                break;
            case 4 :
                tab = "###################"
                    + "#       ccc c     #"
                    + "#c#c# #c# #c# #c# #"
                    + "#  c   c     c   c#"
                    + "#c# #c# # #c#c# # #"
                    + "#c c     c c c   c#"
                    + "# #c#c#c#c#c# #c# #"
                    + "#  c   c   c     c#"
                    + "#C# # #c# # #c# #c#"
                    + "#    cc    c c    #"
                    + "###################";
                break;
            case 5 :
                tab = "###################"
                    + "#     ccccc c     #"
                    + "#c#c# #c# #c# #c# #"
                    + "#  c   c     c   c#"
                    + "#c# #c# # #c#c# # #"
                    + "#c cccccccc c c  c#"
                    + "# #c#c# # #c# #c# #"
                    + "#  c c c c c c   c#"
                    + "#C# # #c# # #c# #c#"
                    + "#    cc    c c    #"
                    + "###################";
                break;
        }
        for(int i = 0; i < cellule.length; i++){
            for(int j = 0; j < cellule[0].length; j++){
                if(indice < 209 && tab.charAt(indice) == '#')
                    cellule[i][j].addObstacle();
                if(indice < 209 && tab.charAt(indice) == 'c')
                    cellule[i][j].addCaisse();
                indice++;
            }
        }
    }
    
    
    /**Méthode permettant la gestion du clavier 
     * pour permettre le déplacement et les actions
     * @param evt*/
    @Override
    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT){
          System.out.println("gauche");
          joueur.deplacement("q");
        }else if (keyCode == KeyEvent.VK_RIGHT){
          System.out.println("droite");
          joueur.deplacement("d");
        }else if (keyCode == KeyEvent.VK_UP){
          System.out.println("avance");
          joueur.deplacement("z");
        }else if (keyCode == KeyEvent.VK_DOWN){
          System.out.println("recule");
          joueur.deplacement("s");
        }else if (keyCode == KeyEvent.VK_SPACE){
          System.out.println("bombe!");
          joueur.poserBombe(true);
        }
      }

    
    @Override
    public void keyReleased(KeyEvent evt) {}

    @Override
    public void keyTyped(KeyEvent evt) {}

    @Override
    public boolean isFocusTraversable() {
      return true;
    }
    
    
    /**Permet d'ajouter un joueur sur le plateau
     * @param joueur*/
    public void addJoueur(Joueur joueur){
        this.joueur = joueur;
        cellule[joueur.getCoordonnees()[1]][joueur.getCoordonnees()[0]].addJoueur(joueur);
        affichePlateau();
    }
    
    
    /**Retourne le plateau sous la forme d'un tableau de cellule
     * @return Cellule[][]*/
    public Cellule[][] getPlateau(){
        return cellule;
    }
    
    
    /**Permet d'afficher le plateau sous la forme graphique*/
    public void affichePlateau(){
        pi = new PicturesPanel(1);
        for(int i = 0; i < cellule.length; i++){
            for(int j = 0; j < cellule[0].length; j++){
                //System.out.print(cellule[i][j] + "|");
                if(cellule[i][j].toString().equals(" ")){
                    pi = new PicturesPanel(1);
                    this.add(pi, gbc);
                }if(cellule[i][j].toString().equals("#"))
                    this.add(new PicturesPanel(2), gbc);
                if(cellule[i][j].toString().equals("J"))
                    this.add(new PicturesPanel(3), gbc);
                if(cellule[i][j].toString().equals("B"))
                    this.add(new PicturesPanel(4), gbc);
                if(cellule[i][j].toString().equals("F"))
                    this.add(new PicturesPanel(5), gbc);
                if(cellule[i][j].toString().equals("c"))
                    this.add(new PicturesPanel(6), gbc);
                gbc.gridx++;
            }
            gbc.gridy++;
            gbc.gridx = 1;
        }
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridy = 1;
        gbc.gridx = 1;
    }
    
    
    /**Permet de mettre à jour le plateau
     * @param s*/
    public void update(String s){
        switch(s){
            case "J":
                cellule[joueur.getCoordonnees()[1]][joueur.getCoordonnees()[0]].addJoueur(joueur);
                break;
        }
        if(joueur != null && joueur.getVie() < 1){
            this.getPlateau()[joueur.getCoordonnees()[1]][joueur.getCoordonnees()[0]].videCase();
            joueur = null;
        }
        this.remove(pi);
        affichePlateau();
        revalidate();
    }
}
