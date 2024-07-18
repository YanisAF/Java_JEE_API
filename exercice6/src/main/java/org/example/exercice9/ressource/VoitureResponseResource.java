package org.example.exercice9.ressource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.exercice9.model.Voiture;
import org.example.exercice9.service.VoitureService;

import java.util.List;

@Path("/voituresresp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VoitureResponseResource {

    private VoitureService voitureService;


    @Inject
    public VoitureResponseResource(VoitureService voitureService){
        this.voitureService = voitureService;
    }

    // CREATE
    @POST
    public Response create(Voiture voiture){
        voitureService.create(voiture);
        return Response.status(Response.Status.CREATED).entity(voiture).build();

    }

    // READ
    @GET
    public List<Voiture> findAll(){
        return voitureService.findAll();
    }

    @GET
    @Path("{id}")
    public Response finfById(@PathParam("id")Long id){
        Voiture voiture = voitureService.findById(id);
        if(voiture == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(voiture).build();
    }

    // UPDATE

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id,Voiture voiture){
        voiture.setId(id);
        Voiture voiture1 = voitureService.update(voiture);
       if (voiture1 != null){
           return Response.ok(voiture1).build();
       }
       return Response.status(Response.Status.NOT_FOUND).build();
    }

    // DELETE
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        voitureService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
