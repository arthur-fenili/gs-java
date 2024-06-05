package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.Login;
import org.example.repository.LoginRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("logins")
public class LoginResource {

    private LoginRepository loginRepository = new LoginRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Login login) {
        loginRepository.Create(login);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Login readById(@PathParam("id") int id) {
        return loginRepository.ReadById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Login> readAll() {
        return loginRepository.ReadAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(Login login, @PathParam("id") int id) {
        loginRepository.UpdateById(login, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        loginRepository.DeleteById(id);
    }
}
