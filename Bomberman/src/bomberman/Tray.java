package bomberman;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public final class Tray extends JPanel implements KeyListener {
    
    private final Cell[][] cellTray;            //Tray in the form of a array to two dimensions
    private final GridBagConstraints gbc;       //Allow to manage the grid bag layout
    private Player player;                      //Players list on the tray
    
    
    /**Initialize the display of the tray and create this*/
    public Tray(){
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
                if (idx < (cellTray.length*cellTray[0].length) && t.charAt(idx) == '#') {
                    cell2.addObstacle();
                } else if (idx < 209 && t.charAt(idx) == 'c') {
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
                player.move('q');
                break;
            case KeyEvent.VK_RIGHT:
                player.move('d');
                break;
            case KeyEvent.VK_UP:
                player.move('z');
                break;
            case KeyEvent.VK_DOWN:
                player.move('s');
                break;
            case KeyEvent.VK_SPACE:
                player.putBomb();
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
    
    
    /**Add a player on the tray
     * @param player*/
    public void addPlayer(Player player){
        this.player = player;
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
                switch (cellTray[i][j].getComponent()) {
                    case ' ':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(1);
                        pp.repaint();
                        break;
                    case '#':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(2);
                        pp.repaint();
                        break;
                    case '1':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(3);
                        pp.repaint();
                        break;
                    case '2':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(3);
                        pp.repaint();
                        break;
                    case 'B':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(4);
                        pp.repaint();
                        break;
                    case 'x':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(5);
                        pp.repaint();
                        break;
                    case 'y':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(6);
                        pp.repaint();
                        break;
                    case 'z':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(7);
                        pp.repaint();
                        break;
                    case 'c':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(8);
                        pp.repaint();
                        break;
                    case 'P':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(9);
                        pp.repaint();
                        break;
                    case 'N':
                        pp = ((PicturesPanel) getComponent(i*19+j));
                        pp.setImage(10);
                        pp.repaint();
                        break;
                }
                gbc.gridx++;
            }
            gbc.gridy++;
            gbc.gridx = 1;
        }
        if(player != null && player.getLife() < 1)
            player = null;
    }
    
    
    /*@Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(Pictures.ground, 0, 0, this.getWidth(), this.getHeight(), this);
    }*/
    
}
