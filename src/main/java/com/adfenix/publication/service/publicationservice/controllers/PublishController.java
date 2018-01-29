package com.adfenix.publication.service.publicationservice.controllers;

import com.adfenix.publication.service.publicationservice.models.Publication;
import com.adfenix.publication.service.publicationservice.services.PublicationService;
import com.adfenix.publication.service.publicationservice.utils.Helper;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Tauhid on 1/10/17.
 */
@Controller
@Path("/")
public class PublishController {

    private static final org.apache.log4j.Logger log = LogManager.getLogger(PublishController.class);

    private PublicationService publicationService;


    @Autowired
    public void setPublicationService(PublicationService publicationService) {
        this.publicationService = publicationService;
    }


    @GET
    @Path("get/list")
    @Produces("application/json")
    public Response listMessages(){
        List<Publication> apiResponse = publicationService.getAllPublications();
        return Response.ok(apiResponse).build();
    }

    @GET
    @Path("send/{message}")
    @Produces("application/json")
    public Response sendMsgToRabbitQueue(@PathParam("message") String message){
        Publication publication = Publication.createInstance(message);
        publicationService.sendPublicationToRabbitQueue(publication);

        return Response.ok(Helper.formatPublishString("Successfully published")).build();
    }
}

