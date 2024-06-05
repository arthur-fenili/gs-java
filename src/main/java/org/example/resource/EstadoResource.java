package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Estado;
import org.example.repository.EstadoRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("estados")
public class EstadoResource {

    private EstadoRepository estadoRepository = new EstadoRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Estado estado) {
        estadoRepository.Create(estado);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Estado readById(@PathParam("id") int id) {
        return estadoRepository.ReadById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> readAll() {
        return estadoRepository.ReadAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Estado estado, @PathParam("id") int id) {
        estadoRepository.UpdateById(estado, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        estadoRepository.DeleteById(id);
    }
}
