package com.albo.comics;

import com.albo.comics.model.CharacterComicMarvelDO;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/marvel")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarvelResource {
    private static final Logger LOG = Logger.getLogger(MarvelResource.class);

    @Inject
    EntityManager entityManager;

    @GET
    @Path("/colaborators/{nameCharacter}")
    public List<CharacterComicMarvelDO> getColaborators(@PathParam String nameCharacter) {
        LOG.info("nameCharacter: " + nameCharacter);
        TypedQuery<CharacterComicMarvelDO> query = entityManager.createNamedQuery("colaborator.findByCharacter", CharacterComicMarvelDO.class);
        query.setParameter("nameCharacter", nameCharacter);

        List<CharacterComicMarvelDO> result = query.getResultList();

        if(result.isEmpty()){
            throw new WebApplicationException("El personaje: " + nameCharacter + " No existe!", 404);
            //throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return result;
    }

    @GET
    @Path("/characters/{nameCharacter}")
    public List<CharacterComicMarvelDO> getCharacters(@PathParam String nameCharacter) {
        LOG.info("nameCharacter: " + nameCharacter);
        TypedQuery<CharacterComicMarvelDO> query = entityManager.createNamedQuery("colaborator.findByCharacter", CharacterComicMarvelDO.class);
        query.setParameter("nameCharacter", nameCharacter);

        List<CharacterComicMarvelDO> result = query.getResultList();

        if(result.isEmpty()){
            throw new WebApplicationException("El personaje: " + nameCharacter + " No existe!", 404);
        }

        return result;
    }
}