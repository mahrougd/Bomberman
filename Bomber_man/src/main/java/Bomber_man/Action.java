/*http://localhost:8080/HommeBombe/webresources/move*/

package Bomber_man;

import bomberman.GameWindow;
import bomberman.Load;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("action")
public class Action {
    
    private int id;
    GameWindow g;
    
    @Context
    private UriInfo context;

    public Action() {
        g = Load.B;
        id = Load.id;
        Load l = new Load();
        l.incId();
    }

    @GET
    @Path("id")
    @Produces(MediaType.APPLICATION_JSON)
    public ObjetTransferer getId(){
        id++;
        return new ObjetTransferer(id);
    }
    
    @GET
    @Path("tab")
    @Produces(MediaType.APPLICATION_JSON)
    public ObjetTransferer getTab(){
        return new ObjetTransferer(g.getTray());
    }
    
    /*@GET
    @Path("run")
    @Produces("text/html")
    public String run(){
        g.start();
        return "<h1>En haut</h1>";
    }*/
    
    @POST
    @Path("up") 
    public void Up(@QueryParam("player") int p){
        g.up(1);
    }

    @POST
    @Path("down")
    @Produces("text/html")
    public void Down(@QueryParam("player") int p){
        g.down(1);
    }
    
    @POST
    @Path("left")
    @Produces("text/html")
    public void Left(@QueryParam("player") int p){
        g.left(1);
    }
    
    @POST
    @Path("right")
    @Produces("text/html")
    public void Right(@QueryParam("player") int p){
        g.right(1);
    }
    
    @POST
    @Path("bomb")
    @Produces("text/html")
    public void Bomb(@QueryParam("player") int p){
        g.bomb(1);
    }
    
}