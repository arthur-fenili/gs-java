package org.example.resource;

import jakarta.ws.rs.*;
import org.example.repository.ClienteNewsletterRepository;
import jakarta.ws.rs.core.MediaType;

@Path("cliente-newsletters")
public class ClienteNewsletterResource {

    private ClienteNewsletterRepository clienteNewsletterRepository = new ClienteNewsletterRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(org.example.entities.ClienteNewsletter clienteNewsletter) {
        clienteNewsletterRepository.Create(clienteNewsletter);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public org.example.entities.ClienteNewsletter readById(@PathParam("id") int id) {
        return clienteNewsletterRepository.ReadById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<org.example.entities.ClienteNewsletter> readAll() {
        return clienteNewsletterRepository.ReadAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(org.example.entities.ClienteNewsletter clienteNewsletter, @PathParam("id") int id) {
        clienteNewsletterRepository.UpdateById(clienteNewsletter, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        clienteNewsletterRepository.DeleteById(id);
    }
    }

