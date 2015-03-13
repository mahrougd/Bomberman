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
    PicturesPanel p1;                           //Panel permettant d'afficher les image (à remove)
    PicturesPanel p2;
    PicturesPanel p3;                           //Panel permettant d'afficher les image (à remove)
    PicturesPanel p4;
    PicturesPanel p5;                           //Panel permettant d'afficher les image (à remove)
    PicturesPanel p6;
    
    
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
        
        this.setLayout(new GridBagLayout());                //Ajout du grid bag layout
        addKeyListener(this);                               //Ajout du key listener
        
        cellule = new Cellule[11][19];                      //Initialisation de la taille du plateau
        for (Cellule[] cellule1 : cellule) {
            for (int j = 0; j < cellule[0].length; j++) {   
                cellule1[j] = new Cellule();                //Initialisation du tableau
            }
        }
        createTab();        //On choisit aléatoirement parmis les 5 tableaux proposés
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
                    + "#    c c cc       #"
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
        for (Cellule[] cellule1 : cellule) {
            for (int j = 0; j < cellule[0].length; j++) {
                if (indice < 209 && tab.charAt(indice) == '#') {
                    cellule1[j].addObstacle();
                } else if (indice < 209 && tab.charAt(indice) == 'c') {
                    cellule1[j].addCaisse();
                }
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
        switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        joueur.deplacement("q");
                        break;
                    case KeyEvent.VK_RIGHT:
                        joueur.deplacement("d");
                        break;
                    case KeyEvent.VK_UP:
                        joueur.deplacement("z");
                        break;
                    case KeyEvent.VK_DOWN:
                        joueur.deplacement("s");
                        break;
                    case KeyEvent.VK_SPACE:
                        joueur.poserBombe(true);
                        break;
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
    }
    
    
    /**Retourne le plateau sous la forme d'un tableau de cellule
     * @return Cellule[][]*/
    public Cellule[][] getPlateau(){
        return cellule;
    }
    
    
    /**Permet d'afficher le plateau*/
    public void affichePlateau(){
        for (Cellule[] cellule1 : cellule) {
            for (int j = 0; j < cellule[0].length; j++) {
                switch (cellule1[j].toString()) {
                    case  " ":
                        this.add(new PicturesPanel(1), gbc);
                        break;
                    case "#":
                        this.add(new PicturesPanel(2), gbc);
                        break;
                    case "J1":
                        this.add(new PicturesPanel(3), gbc);
                        break;
                    case "J2":
                        this.add(new PicturesPanel(3), gbc);
                        break;
                    case "B":
                        this.add(new PicturesPanel(4), gbc);
                        break;
                    case "F":
                        this.add(new PicturesPanel(5), gbc);
                        break;
                    case "c":
                        this.add(new PicturesPanel(6), gbc);
                        break;
                }
                gbc.gridx++;
            }
            gbc.gridy++;
            gbc.gridx = 1;
        }
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridy = 1;
        gbc.gridx = 1;
    }
    
    
    
    public void update(){
        PicturesPanel pp;
        for (int i = 0; i < cellule.length; i++) {
            for (int j = 0; j < cellule[0].length; j++) {
                switch (cellule[i][j].toString()) {
                    case " ":
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(1);
                        pp.repaint();
                        break;
                    case "#":
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(2);
                        pp.repaint();
                        break;
                    case "J1":
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(3);
                        pp.repaint();
                        break;
                    case "J2":
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(3);
                        pp.repaint();
                        break;
                    case "B":
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(4);
                        pp.repaint();
                        break;
                    case "F":
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(5);
                        pp.repaint();
                        break;
                    case "c":
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(6);
                        pp.repaint();
                        break;
                    case "P":
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(7);
                        pp.repaint();
                        break;
                    case "N":
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(8);
                        pp.repaint();
                        break;
                }
                gbc.gridx++;
            }
            gbc.gridy++;
            gbc.gridx = 1;
        }
    }
    
    
    /*@Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(Pictures.ground, 0, 0, this.getWidth(), this.getHeight(), this);
    }*/
    
}
