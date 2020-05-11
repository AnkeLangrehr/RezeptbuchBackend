package rest;

import Entities.RezeptEntity;
import Services.RecipeService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/recipes")
public class RecipesRestResources {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RezeptEntity> getRecipes() {
        List<RezeptEntity> rezeptEntities = null;
        try {
            RecipeService recipeService = new RecipeService();
            rezeptEntities = recipeService.getAllRecipes();
            System.out.println(rezeptEntities);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(rezeptEntities.size());
        }
        return rezeptEntities;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RezeptEntity getRecipe(@PathParam("id") int id) {
        RecipeService recipeService = new RecipeService();
        RezeptEntity recipe=recipeService.getRecipe(id);
        return recipe;
    }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRecipe(@PathParam("id") int id){
        RecipeService recipeService= new RecipeService();
        recipeService.deleteRecipe(id);
        return Response.ok().build();
    }

    @POST
    @Path("/{id}/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRecipe(@PathParam("id") int id, @PathParam("name") String name){
        RecipeService recipeService= new RecipeService();
        String beschreibung = null;
        recipeService.createRecipe(id, beschreibung, name);
        return Response.ok().build();
    }
    /*@POST
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRecipe(@PathParam("recipe") RezeptEntity recipe){

        RecipeService recipeService= new RecipeService();
        recipeService.createRecipe(recipe.getId(), recipe.getBeschreibung(), recipe.getName());
        return Response.ok().build();
    }*/
}