package bomberman;

import java.util.ArrayList;

public final class Tray {
    
    private final Cell[][] cellTray;            //Tray in the form of a array to two dimensions
    private final ArrayList<Player> playerList; //Players list on the tray
    
    
    /**Initialize the display of the tray and create this*/
    public Tray(){
        
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
        for (Cell[] cellTray1 : cellTray) {
            for (int j = 0; j < cellTray[0].length; j++) {
                System.out.print(cellTray1[j].getComponent() + "|");
            }
            System.out.print("\n");
        }
    }
    
    
    /**Update the tray*/
    public void update(){
        for (Cell[] cellTray1 : cellTray) {
            for (int j = 0; j < cellTray[0].length; j++) {
                System.out.print(cellTray1[j].getComponent() + "|");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for(Player p : playerList){
            if(p.getLife() < 1)
                playerList.remove(p);
        }  

    }
    
    
    //Return the tray to string
    @Override
    public String toString(){
        if(playerList.size() == 1)
            return "end";
        String tab = "";
        for (Cell[] cellTray1 : cellTray) {
            for (int j = 0; j < cellTray[0].length; j++){
                    tab += cellTray1[j].getComponent();
            }
        }
        return tab;
    }
    
}
