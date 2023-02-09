package com.paf.hey;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.Separator;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hellos")
public class HelloController {
    @GET
    public String hello(@BeanParam Hello hello) {
        List<String> names = Optional.ofNullable(hello.names).orElse(Collections.emptyList());
        return "Hello " + String.join("|", names);
    }

    public static class Hello {
        @RestQuery
        @Separator(",")
        List<String> names;
    }

}
