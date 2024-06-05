package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Controle;
import org.example.repository.ControleRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("controles")
public class ControleResource {

    private ControleRepository controleRepository = new ControleRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Controle controle) {
        controleRepository.Create(controle);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Controle readById(@PathParam("id") int id) {
        return controleRepository.ReadById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Controle> readAll() {
        return controleRepository.ReadAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Controle controle, @PathParam("id") int id) {
        controleRepository.UpdateById(controle, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        controleRepository.DeleteById(id);
    }
}
