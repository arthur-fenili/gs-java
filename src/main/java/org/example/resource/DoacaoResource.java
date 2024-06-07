package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Doacao;
import org.example.repository.DoacaoRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("doacoes")
public class DoacaoResource {

    private DoacaoRepository doacaoRepository = new DoacaoRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Doacao doacao) {
        doacaoRepository.create(doacao);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doacao readById(@PathParam("id") int id) {
        return doacaoRepository.readById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doacao> readAll() {
        return doacaoRepository.readAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Doacao doacao, @PathParam("id") int id) {
        doacaoRepository.updateById(doacao, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        doacaoRepository.deleteById(id);
    }
}
