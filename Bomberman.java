package bomberman;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bomberman")
public class Bomberman{
 
	@GET
	@Path("/main")
	@Produces(MediaType.TEXT_PLAIN)
    public static void main(String[] args) {
        Fenetre f = new Fenetre();
    }
    
}

