/*http://localhost:8080/HommeBombe/webresources/move*/

package hommebombe;

import bomberman.GameWindow;
import bomberman.Load;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("move")
public class Moves {
    
    private int id;
    GameWindow g;
    
    @Context
    private UriInfo context;

    public Moves() {
        g = Load.B;
        id = Load.id;
        Load l = new Load();
        l.incId();
    }

    @GET
    @Path("id")
    @Produces(MediaType.APPLICATION_JSON)
    public ObjetTransferer getId() {
        id++;
        return new ObjetTransferer(id);
    }
    
    @GET
    @Path("tab")
    @Produces(MediaType.APPLICATION_JSON)
    public ObjetTransferer getTab() {
        return new ObjetTransferer(g.getTray());
    }
    
    @GET
    @Path("run")
    @Produces("text/html")
    public String run() {
        g.start();
        return "<h1>En haut</h1>";
    }
    
    @POST
    @Path("up") 
    public void Up(@QueryParam("player") int p) {
        g.up(p);
    }

    @POST
    @Path("down")
    @Produces("text/html")
    public void Down(@QueryParam("player") int p) {
        g.down(p);
    }
    
    @POST
    @Path("left")
    @Produces("text/html")
    public void Left(@QueryParam("player") int p) {
        g.left(p);
    }
    
    @POST
    @Path("right")
    @Produces("text/html")
    public void Right(@QueryParam("player") int p) {
        g.right(p);
    }
    
    @POST
    @Path("bomb")
    @Produces("text/html")
    public void Bomb(@QueryParam("player") int p) {
        g.bomb(p);
    }
    
    /*@GET
    @Path("tab")
    @Produces("text/html")
    public String getTab() {
        return getHTML();
    }*/
    
    public String getHTML(){
        return "<!DOCTYPE>" +
                    "<html>" +
                        "<head>" +
                            "<meta charset=\"UTF-8\">" +
                            "<title>Bomberman</title>" +
                            //"<meta http-equiv=\"refresh\" content=\"1;url=http://172.19.171.178:8080/HommeBombe/webresources/move/tab\" />" +
                            "<script src='../../jquery-2.1.3.js'></script>" + 
                            "<script src='../../p5.min.js'></script>" + 
                        "</head>" +
                        "<body onkeypress=\"myFunction()\">" +
                            
                            "<script>" +
                
                                "function setup() {" +
                                    "createCanvas(950, 550);" +
                                    "background(0, 121, 60);" +
                                    "fill(200);" +
                                    "afficherPlateau();" +
                                "}" +
                
                                "function draw(){" +
                                    "$.ajax({" +
                                        "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/left?player=2'," +
                                        "type: 'POST'," +
                                    "});" +
                                    "afficherPlateau();" +
                                "}" +

                                "var imgBomb = new Image();" +
                                "var imgBox = new Image();" +
                                "var imgObstacle = new Image();" +
                                "var imgPlayer1 = new Image();" +
                                "var imgPlayer2 = new Image();" +
                                "var imgBonusBomb = new Image();" +
                                "var imgBonusPowerful = new Image();" +
                                "var imgFlame1 = new Image();" +
                                "var imgFlame2 = new Image();" +
                                "var imgFlame3 = new Image();" +

                                "var tray = \"" + g.getTray() + "\";" +

                                "function preload() {" +
                                    "imgBomb = loadImage(\"../../Images/Bomb.png\");" +
                                    "imgBox = loadImage(\"../../Images/Box.png\");" +
                                    "imgPlayer1 = loadImage(\"../../Images/Player.png\");" +
                                    "imgPlayer2 = loadImage(\"../../Images/Player1.png\");" +
                                    "imgObstacle = loadImage(\"../../Images/Obstacle.png\");" +
                                    "imgBonusBomb = loadImage(\"../../Images/BonusBomb.png\");" +
                                    "imgBonusPowerful = loadImage(\"../../Images/BonusPowerful.png\");" +
                                    "imgFlame1 = loadImage(\"../../Images/Flame1.png\");" +
                                    "imgFlame2 = loadImage(\"../../Images/Flame2.png\");" +
                                    "imgFlame3 = loadImage(\"../../Images/Flame3.png\");" +
                                "}" +

                                "function afficherPlateau() {" +
                                    "var state;" +
                                    "var idx = 0;" +
                                    "for(var y = 0; y < 550; y += 50){" +
                                        "for(var x = 0; x < 950; x += 50){" +
                                            "state = tray.charAt(idx);" +
                                            "switch (state){" +
                                                "case '#':" +
                                                    "image(imgObstacle, x, y, 50, 50);" +
                                                    "break;" +
                                                "case 'c':" +
                                                    "image(imgBox, x, y, 50, 50);" +
                                                    "break;" +
                                                "case 'B':" +
                                                    "image(imgBomb, x, y, 50, 50);" +
                                                    "break;" +
                                                "case '1':" +
                                                    "image(imgPlayer1, x, y, 50, 50);" +
                                                    "break;" +
                                                "case '2':" +
                                                    "image(imgPlayer2, x, y, 50, 50);" +
                                                    "break;" +
                                                
                                                "case 'P':" +
                                                    "image(imgBonusPowerful, x, y, 50, 50);" +
                                                    "break;" +
                                                "case 'N':" +
                                                   "image(imgBonusBomb, x, y, 50, 50);" +
                                                    "break;" +
                                                "case 'x':" +
                                                    "image(imgFlame1, x, y, 50, 50);" +
                                                    "break;" +
                                                "case 'y':" +
                                                    "image(imgFlame2, x, y, 50, 50);" +
                                                    "break;" +
                                                "case 'z':" +
                                                    "image(imgPlayer3, x, y, 50, 50);" +
                                                    "break;" +
                                            "}" +
                                            "idx++;" +
                                        "}" +
                                    "}" +
                                "}" +
                
                                "window.onkeyup = function(e) {" +
                                    "var key = e.keyCode ? e.keyCode : e.which;" +
                                    "if (key == 38) {" +
                                        "$.ajax({" +
                                            "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/up?player=2'," +
                                            "type: 'POST'," +
                                        "});" +
                                    "} else if(key == 40) {" +
                                        "$.ajax({" +
                                            "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/down?player=2'," +
                                            "type: 'POST'," +
                                        "});" +
                                    "} else if(key == 39) {" +
                                        "$.ajax({" +
                                            "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/right?player=2'," +
                                            "type: 'POST'," +
                                        "});" +
                                    "} else if(key == 37) {" +
                                        "$.ajax({" +
                                            "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/left?player=2'," +
                                            "type: 'POST'," +
                                        "});" +
                                    "} else if(key == 17) {" +
                                        "$.ajax({" +
                                            "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/bomb?player=2'," +
                                            "type: 'POST'," +
                                        "});" +
                                    "} else if (key == 90) {" +
                                        "$.ajax({" +
                                            "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/up?player=1'," +
                                            "type: 'POST'," +
                                        "});" +
                                    "} else if(key == 83) {" +
                                        "$.ajax({" +
                                            "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/down?player=1'," +
                                            "type: 'POST'," +
                                        "});" +
                                    "} else if(key == 68) {" +
                                        "$.ajax({" +
                                            "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/right?player=1'," +
                                            "type: 'POST'," +
                                        "});" +
                                    "} else if(key == 81) {" +
                                        "$.ajax({" +
                                            "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/left?player=1'," +
                                            "type: 'POST'," +
                                        "});" +
                                    "} else if(key == 32) {" +
                                        "$.ajax({" +
                                            "url: 'http://172.19.171.178:8080/HommeBombe/webresources/move/bomb?player=1'," +
                                            "type: 'POST'," +
                                        "});" +
                                    "}" +
                                "}" +
                            "</script>" +
                        "</body>" +
                    "</html>";
    }
    
}