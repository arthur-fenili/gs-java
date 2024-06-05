package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Endereco;
import org.example.repository.EnderecoRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("enderecos")
public class EnderecoResource {

    private EnderecoRepository enderecoRepository = new EnderecoRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Endereco endereco) {
        enderecoRepository.Create(endereco);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco readById(@PathParam("id") int id) {
        return enderecoRepository.ReadById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Endereco> readAll() {
        return enderecoRepository.ReadAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Endereco endereco, @PathParam("id") int id) {
        enderecoRepository.UpdateById(endereco, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        enderecoRepository.DeleteById(id);
    }
}
