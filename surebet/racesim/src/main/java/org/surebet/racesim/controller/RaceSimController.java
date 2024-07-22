package org.surebet.racesim.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/racesim")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class RaceSimController {

    @GET
    @Path("/resource")
    public Response getResource() {
        return Response.ok("Duh Duh DuhDuh, Max Verstappen!").build();
    }
}
