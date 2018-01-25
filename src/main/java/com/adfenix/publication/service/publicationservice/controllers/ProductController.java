package com.adfenix.publication.service.publicationservice.controllers;

import com.adfenix.publication.service.publicationservice.models.Publication;
import com.adfenix.publication.service.publicationservice.services.PublicationService;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tauhid on 1/10/17.
 */
@Controller
@Path("/")
public class ProductController {

    private static final org.apache.log4j.Logger log = LogManager.getLogger(ProductController.class);

    private PublicationService productService;


    @Autowired
    public void setProductService(PublicationService productService) {
        this.productService = productService;
    }

//    @Path("/")
//    public String redirectToList(){
//        return "redirect:/get/list";
//    }
    @GET
    @Path("get/list")
    @Produces("application/json")
    public Response listMessages(){
        Map<String, String> apiResponse = productService.getAllPublishedMessages();
        return Response.ok(apiResponse).build();
    }

    @GET
    @Path("send/{msg}")
    @Produces("application/json")
    public Response sendMsgToRabbitQueue(@PathParam("msg") String message){
        Publication publication = new Publication();
        publication.setMessage(message);
        productService.sendPublicationToRabbitQueue(publication);

        return Response.ok("{Message:'Done'}").build();
    }

    @POST
    @Path("send/")
    @Produces("application/json")
    public Response sendMsgToRabbitQueuePOST(@RequestParam("message") String message){
        Publication publication = new Publication();
        publication.setMessage(message);
        productService.sendPublicationToRabbitQueue(publication);

        return Response.ok("{Message:'Done'}").build();
    }
}

