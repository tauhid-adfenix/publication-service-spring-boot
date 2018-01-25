package com.adfenix.publication.service.publicationservice.config;

import com.adfenix.publication.service.publicationservice.controllers.ProductController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;


import javax.ws.rs.ApplicationPath;

@Configuration
@Controller
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ProductController.class);
    }
}