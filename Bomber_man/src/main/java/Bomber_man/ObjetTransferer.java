package Bomber_man;

//This class serves as container for the data to be passed on to the customer
public class ObjetTransferer {
    
    private int id;
    private String tray;
    
    public ObjetTransferer() {
    }

    public ObjetTransferer(int id) {
        this.id = id;
    }
    
    public ObjetTransferer(String tray) {
        this.tray = tray;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTray(String tray) {
        this.tray = tray;
    }

    public String getTray() {
        return tray;
    }
    
}
