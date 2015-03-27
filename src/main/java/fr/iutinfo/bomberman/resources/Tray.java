package fr.iutinfo.bomberman.resources;

import fr.iutinfo.bomberman.models.*;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class Tray extends JPanel implements KeyListener {
    
    private final Cell[][] cellTray;            //Tray in the form of a array to two dimensions
    private final GridBagConstraints gbc;       //Allow to manage the grid bag layout
    private final ArrayList<Player> playerList; //Players list on the tray
    
    
    /**Initialize the display of the tray and create this*/
    public Tray(){
        this.setBackground(new Color(0, 121, 60));
        
        gbc = new GridBagConstraints();                 //
        gbc.gridx = 1;                                  //
        gbc.gridy = 1;                                  //
        gbc.gridwidth = 1;                              //
        gbc.gridheight = 1;                             //
        gbc.weightx = 100;                              //
        gbc.weighty = 100;                              //Define the constraintes of grid bag layout
        gbc.fill = GridBagConstraints.NONE;             //
        gbc.anchor = GridBagConstraints.NORTHWEST;      //
        gbc.insets = new Insets(0,0,0,0);               //
        gbc.ipadx = 50;                                 //
        gbc.ipady = 50;                                 //
        
        this.setLayout(new GridBagLayout());            //Add grid bag layout
        addKeyListener(this);                           //Add key listener
        
        playerList = new ArrayList<>();
        
        cellTray = new Cell[11][19];                    //Initialization of tray length
        for (Cell[] cell1 : cellTray) {
            for (int j = 0; j < cellTray[0].length; j++) {   
                cell1[j] = new Cell();                  //Create tray
            }
        }
        initTray();
    }
    
    
    /**Allow to create a tray from the five preconfigure in this method*/
    private void initTray(){
        String t = "";
        int idx = 0;
        switch((int)(Math.random() * 5) + 1){  
            case 1 :
                t = "###################"
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
                t = "###################"
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
                t = "###################"
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
                t = "###################"
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
                t = "###################"
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
        for (Cell[] cell1 : cellTray) {
            for (Cell cell2 : cell1) {
                if (t.charAt(idx) == '#') {
                    cell2.addObstacle();
                } else if (t.charAt(idx) == 'c') {
                    cell2.addBox();
                }
                idx++;
            }
        }
    }
    
    
    /**Method allow the listen of keyboard to 
     * manage the moves and the actions of player
     * @param evt*/
    @Override
    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                playerList.get(1).move('q');
                break;
            case KeyEvent.VK_RIGHT:
                playerList.get(1).move('d');
                break;
            case KeyEvent.VK_UP:
                playerList.get(1).move('z');
                break;
            case KeyEvent.VK_DOWN:
                playerList.get(1).move('s');
                break;
            case KeyEvent.VK_CONTROL:
                playerList.get(1).putBomb();
                break;
            case KeyEvent.VK_Z:
                playerList.get(0).move('z');
                break;
            case KeyEvent.VK_S:
                playerList.get(0).move('s');
                break;
            case KeyEvent.VK_Q:
                playerList.get(0).move('q');
                break;
            case KeyEvent.VK_D:
                playerList.get(0).move('d');
                break;
            case KeyEvent.VK_SPACE:
                playerList.get(0).putBomb();
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
    
    
    /**Add a player on the tray and in the player list
     * @param player new player in the game*/
    public void addPlayer(Player player){
        this.playerList.add(player);
        cellTray[player.getY()][player.getX()].addPlayer(player);
    }
    
    
    /**Return the tray under the shape of a array of cell
     * @return Cellule[][]*/
    public Cell[][] getBoardTray(){
        return cellTray;
    }
    
    
    /**Allow to display the tray*/
    public void displayTray(){
        for (Cell[] cell1 : cellTray) {
            for (Cell cell2 : cell1) {
                switch (cell2.getComponent()) {
                    case ' ':
                        this.add(new PicturesPanel(1), gbc);
                        break;
                    case '#':
                        this.add(new PicturesPanel(2), gbc);
                        break;
                    case '1':
                        this.add(new PicturesPanel(3), gbc);
                        break;
                    case '2':
                        this.add(new PicturesPanel(3), gbc);
                        break;
                    case 'c':
                        this.add(new PicturesPanel(8), gbc);
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
    
    
    /**Update the tray*/
    public void update(){
        PicturesPanel pp;
        for (int i = 0; i < cellTray.length; i++) {
            for (int j = 0; j < cellTray[0].length; j++) {
                System.out.print(cellTray[i][j].getComponent() + "|");
                pp = ((PicturesPanel) getComponent(i*19+j));
                switch (cellTray[i][j].getComponent()) {
                    case '#':
                        //pp.setImage(2);
                        break;
                    case 'c':
                        //pp.setImage(8);
                        break;
                    case ' ':
                        pp.setImage(1);
                        break;
                    case '1':
                        pp.setImage(3);
                        break;
                    case '2':
                        pp.setImage(3);
                        break;
                    case 'B':
                        pp.setImage(4);
                        break;
                    case 'x':
                        pp.setImage(5);
                        break;
                    case 'y':
                        pp.setImage(6);
                        break;
                    case 'z':
                        pp.setImage(7);
                        break;
                    case 'P':
                        pp.setImage(9);
                        break;
                    case 'N':
                        pp.setImage(10);
                        break;
                }
                pp.repaint();
                gbc.gridx++;
            }  
            System.out.print("\n");
            gbc.gridy++;
            gbc.gridx = 1;
        }
        System.out.print("\n");
        for(Player p : playerList){
            if(p.getLife() < 1)
                playerList.remove(p);
        }  
        if(playerList.size() == 1)
            JOptionPane.showMessageDialog(null,"Le joueur " + playerList.get(0).getId() + " à gagné !", "Game Over", JOptionPane.WARNING_MESSAGE);
    }
    
}
