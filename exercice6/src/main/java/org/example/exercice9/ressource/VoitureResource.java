package org.example.exercice9.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice9.model.Voiture;
import org.example.exercice9.service.VoitureService;

import java.util.List;

@Path("/voitures")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VoitureResource {

    private VoitureService voitureService;

    @Inject
    public VoitureResource(VoitureService voitureService){
        this.voitureService = voitureService;
    }

    @GET
    @Path("/{id}")
    public Voiture finfById(@PathParam("id")Long id){
        return voitureService.findById(id);
    }

    @GET
    public List<Voiture> findAll(){
        return voitureService.findAll();
    }

    @POST
    public Voiture create(Voiture voiture){
        voitureService.create(voiture);
        return voiture;
    }

    @PUT
    @Path("/{id}")
    public Voiture update(@PathParam("id") Long id,Voiture voiture){
        voiture.setId(id);
        return voitureService.update(voiture);
    }

    @DELETE
    @Path("/{id}")
    public List<Voiture> delete(@PathParam("id")Long id){
        voitureService.delete(id);
        return voitureService.findAll();
    }


}
