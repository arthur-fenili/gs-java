package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.ClienteNewsletter;
import org.example.repository.ClienteNewsletterRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("cliente-newsletters")
public class ClienteNewsletterResource {

    private ClienteNewsletterRepository clienteNewsletterRepository = new ClienteNewsletterRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(org.example.entities.ClienteNewsletter clienteNewsletter) {
        clienteNewsletterRepository.create(clienteNewsletter);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public org.example.entities.ClienteNewsletter readById(@PathParam("id") int id) {
        return clienteNewsletterRepository.readById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClienteNewsletter> readAll() {
        return clienteNewsletterRepository.readAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(org.example.entities.ClienteNewsletter clienteNewsletter, @PathParam("id") int id) {
        clienteNewsletterRepository.updateById(clienteNewsletter, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        clienteNewsletterRepository.deleteById(id);
    }
    }

