package com.adfenix.publication.service.publicationservice.services;

import com.adfenix.publication.service.publicationservice.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PublicationServiceImp implements PublicationService {
    private List<Publication> publicationList = new ArrayList<>();

    @Autowired
    private RabbitMqMsgPublisher publisher;

    @Override
    public void sendPublicationToRabbitQueue(Publication publication) {
        String message = publication.getMessage();
        publisher.send(message);
        addToPublicationVault(publication);
    }

    @Override
    public List<Publication> getAllPublications() {
        return publicationList;
    }


    private void addToPublicationVault(Publication publication) {
        this.publicationList.add(publication);
    }

}
