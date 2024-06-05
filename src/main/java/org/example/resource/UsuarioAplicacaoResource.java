package org.example.resource;

import jakarta.ws.rs.*;
import org.example.entities.UsuarioAplicacao;
import org.example.repository.UsuarioAplicacaoRepository;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("usuario-aplicacao")
public class UsuarioAplicacaoResource {

    private UsuarioAplicacaoRepository usuarioAplicacaoRepository = new UsuarioAplicacaoRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(UsuarioAplicacao usuarioAplicacao) {
        usuarioAplicacaoRepository.Create(usuarioAplicacao);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioAplicacao readById(@PathParam("id") int id) {
        return usuarioAplicacaoRepository.ReadById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsuarioAplicacao> readAll() {
        return usuarioAplicacaoRepository.ReadAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(UsuarioAplicacao usuarioAplicacao, @PathParam("id") int id) {
        usuarioAplicacaoRepository.UpdateById(usuarioAplicacao, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") int id) {
        usuarioAplicacaoRepository.DeleteById(id);
    }
}
