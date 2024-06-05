package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Cidade;
import org.example.repository.CidadeRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("cidades")
public class CidadeResource {

    private CidadeRepository cidadeRepository = new CidadeRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Cidade cidade) {
        cidadeRepository.Create(cidade);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade readById(@PathParam("id") int id) {
        return cidadeRepository.ReadById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cidade> readAll() {
        return cidadeRepository.ReadAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Cidade cidade, @PathParam("id") int id) {
        cidadeRepository.UpdateById(cidade, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        cidadeRepository.DeleteById(id);
    }
}
