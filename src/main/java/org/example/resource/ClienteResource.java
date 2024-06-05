package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Cliente;
import org.example.repository.ClienteRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("clientes")
public class ClienteResource {

    private ClienteRepository clienteRepository = new ClienteRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Cliente cliente) {
        clienteRepository.Create(cliente);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente readById(@PathParam("id") int id) {
        return clienteRepository.ReadById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> readAll() {
        return clienteRepository.ReadAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Cliente cliente, @PathParam("id") int id) {
        clienteRepository.UpdateById(cliente, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        clienteRepository.DeleteById(id);
    }
}
