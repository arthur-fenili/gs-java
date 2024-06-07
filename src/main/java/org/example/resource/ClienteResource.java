package org.example.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.example.entities.Cliente;
import org.example.repository.ClienteRepository;
import jakarta.ws.rs.core.MediaType;
import org.example.service.ClienteService;

import java.util.List;

@Path("clientes")
public class ClienteResource {

    private ClienteRepository clienteRepository = new ClienteRepository();
    private ClienteService clienteService = new ClienteService();


    public ClienteResource() {
        clienteRepository = new ClienteRepository();
        clienteService = new ClienteService();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Cliente cliente) {
        try {
            clienteService.create(cliente);
            return Response.status(Response.Status.CREATED).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente readById(@PathParam("id") int id) {
        return clienteRepository.readById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> readAll() {
        return clienteRepository.readAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateById(Cliente cliente, @PathParam("id") int id) {
        try {
            clienteService.updateById(cliente, id);
            return Response.status(Response.Status.OK).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteById(@PathParam("id") int id) {
        try {
            clienteRepository.deleteById(id);
            return Response.status(Response.Status.OK).build();
        } catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
