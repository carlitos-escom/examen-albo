package com.albo.comics;

import com.albo.comics.json.ColaboratorDataMarvel;
import com.albo.comics.service.MarvelService;
import org.json.JSONObject;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/marvel")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarvelResource {
    private static final Logger LOG = Logger.getLogger(MarvelResource.class);

    @Inject
    EntityManager entityManager;

    @Inject
    MarvelService marvelService;

    @GET
    @Path("/colaborators/{nameCharacter}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(example = Constantes.responseSuccessColaborator)), description = "Operacion Exitosa " + "200")
    @APIResponse(responseCode = "200A", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(example = Constantes.responseBadColaborator)), description = "Operacion Incorrecta " + "200A")
    @Operation(summary = "Servicio para obtener los colaborators", description = "Este servicio convierte la información")
    public Response getColaborators(@PathParam String nameCharacter) {
        LOG.info("getColaborators nameCharacter: " + nameCharacter);

        ColaboratorDataMarvel colaboratorDataMarvel = marvelService.transformColaborator(nameCharacter);

        if(colaboratorDataMarvel.editors.isEmpty() && colaboratorDataMarvel.writers.isEmpty() && colaboratorDataMarvel.colorists.isEmpty()){
            LOG.info("No existe nameCharacter: " + nameCharacter);
            Response.status(404, "El personaje: " + nameCharacter + " No existe!").build();
        }

        return Response.ok(colaboratorDataMarvel).status(201).build();
    }

    @GET
    @Path("/characters/{nameCharacter}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(example = Constantes.responseSuccessCharacter)), description = "Operacion Exitosa " + "200")
    @APIResponse(responseCode = "200A", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(example = Constantes.responseBadCharacter)), description = "Operacion Incorrecta " + "200A")
    @Operation(summary = "Servicio para obtener los herores que nuestro personaje interactua", description = "Este servicio convierte la información")
    public Response getCharacters(@PathParam String nameCharacter) {
        LOG.info("getCharacters nameCharacter: " + nameCharacter);
        Response response = null;
        try {
            ColaboratorDataMarvel colaboratorDataMarvel = marvelService.transformCharacter(nameCharacter);
            if(colaboratorDataMarvel.editors.isEmpty() && colaboratorDataMarvel.writers.isEmpty() && colaboratorDataMarvel.colorists.isEmpty()){
                LOG.info("No existe nameCharacter: " + nameCharacter);
                response = Response.status(404, "El personaje: " + nameCharacter + " No existe!").build();
            }else{
                response = Response.ok(colaboratorDataMarvel).status(201).build();
            }
        } catch (Exception e) {
            response = getResponseError(e);
        }

        return response;
    }

    public Response getResponseError(Exception e) {

        JSONObject response;
        Response.ResponseBuilder responseWithStatus;
        response = new JSONObject();
        response.put("response", "error");
        response.put("exception", new JSONObject().put("detail", e.getMessage()));

        responseWithStatus = Response.status(200).entity(response.toString());
        return responseWithStatus.build();
    }
}