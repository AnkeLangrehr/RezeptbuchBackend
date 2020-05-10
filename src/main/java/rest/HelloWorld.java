package rest;

import Entities.RezeptEntity;
import Services.RecipeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
    @GET
    @Path("/recipes")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRecipes() {
        List<RezeptEntity> rezeptEntities=null;
        try {
            RecipeService recipeService = new RecipeService();
            rezeptEntities = recipeService.getAllRecipes();
            System.out.println(rezeptEntities);
        }catch (Exception e){
           e.printStackTrace();
           System.out.println(rezeptEntities.size());
        }
        return "Hallo Welt" ;
    }
    @GET
    @Path("/recipe")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipe(){
        RecipeService recipeService= new RecipeService();
        recipeService.getRecipeDescription();
        return Response.ok().build();
    }
}