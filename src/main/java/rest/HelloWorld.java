package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/tutorial")
public class HelloWorld
{

    @GET
    @Path("/helloworld")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloworld() {
        System.out.println("klappt");
        return "Hello World!";
    }
}