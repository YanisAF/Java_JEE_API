package org.example.exercice9;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;


@Provider
public class CorsFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
       // permettre à toutes les origines d'acceder aux ressources
        containerResponseContext.getHeaders().add("Access-Control-Allow-Origin","*");
        // requete HTTP autorisées
        containerResponseContext.getHeaders().add("Access-Control-Allow-Methods","GET,POST,DELETE,PUT");
        // en-tete autorisées pour les requete cross-orrigin
        containerResponseContext.getHeaders().add("Access-Control-Allow-Header","Content-Type,Authorization");

    }
}
