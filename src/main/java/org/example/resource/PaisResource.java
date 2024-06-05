package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Pais;
import org.example.repository.PaisRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("paises")
public class PaisResource {

    private PaisRepository paisRepository = new PaisRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Pais pais) {
        paisRepository.Create(pais);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pais readById(@PathParam("id") int id) {
        return paisRepository.ReadById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pais> readAll() {
        return paisRepository.ReadAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Pais pais, @PathParam("id") int id) {
        paisRepository.UpdateById(pais, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        paisRepository.DeleteById(id);
    }
}
