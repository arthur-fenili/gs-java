package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Bairro;
import org.example.repository.BairroRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("bairros")
public class BairroResource {

    private BairroRepository bairroRepository = new BairroRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Bairro bairro) {
        bairroRepository.Create(bairro);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bairro readById(@PathParam("id") int id) {
        return bairroRepository.ReadById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bairro> readAll() {
        return bairroRepository.ReadAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Bairro bairro, @PathParam("id") int id) {
        bairroRepository.UpdateById(bairro, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        bairroRepository.DeleteById(id);
    }
}
