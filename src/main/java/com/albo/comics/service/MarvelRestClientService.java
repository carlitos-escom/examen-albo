package com.albo.comics.service;

import com.albo.comics.marvel.json.ResponseMarvel;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/v1/public")
@RegisterRestClient
public interface MarvelRestClientService {

    @GET
    @Path("/characters")
    @Produces("application/json")
    ResponseMarvel getCharacters(@QueryParam("ts") String ts, @QueryParam("apikey") String apikey, @QueryParam("hash") String hash);
    //Set<ResponseMarvel> getCharacters(@QueryParam("name") String name, @QueryParam("ts") String ts, @QueryParam("apikey") String apikey, @QueryParam("hash") String hash);

    @GET
    @Path("/comics")
    @Produces("application/json")
    ResponseMarvel getComics(@QueryParam("ts") String ts, @QueryParam("apikey") String apikey, @QueryParam("hash") String hash, @QueryParam("offset") String offset);

    @GET
    @Path("/comics")
    @Produces("application/json")
    ResponseMarvel getComics(@QueryParam("ts") String ts, @QueryParam("apikey") String apikey, @QueryParam("hash") String hash);
}
