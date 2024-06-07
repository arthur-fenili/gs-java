package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Newsletter;
import org.example.repository.NewsletterRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("newsletters")
public class NewsletterResource {

    private NewsletterRepository newsletterRepository = new NewsletterRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Newsletter newsletter) {
        newsletterRepository.create(newsletter);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Newsletter readById(@PathParam("id") int id) {
        return newsletterRepository.readById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Newsletter> readAll() {
        return newsletterRepository.readAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Newsletter newsletter, @PathParam("id") int id) {
        newsletterRepository.updateById(newsletter, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        newsletterRepository.deleteById(id);
    }
}
