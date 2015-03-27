/*http://localhost:8080/HommeBombe/webresources/test*/

package hommebombe;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@Path("test")
public class Test {

    @Context
    private UriInfo context;

    public Test() {
    }

    @GET
    //@Produces("application/xml")
    @Produces("text/html")
    public String getXml() {
        return "<h1>Bonjour Medhi</h1>";
    }

    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}