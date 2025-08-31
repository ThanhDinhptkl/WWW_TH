package com.example.restapidemo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello-world")
public class HelloResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "{\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"age\": 30,\n" +
                "  \"isStudent\": false\n" +
                "}";
    }
}