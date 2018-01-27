package com.adfenix.publication.service.publicationservice.services;

import com.adfenix.publication.service.publicationservice.models.Publication;

import java.util.List;

public interface PublicationService {
    void sendPublicationToRabbitQueue(Publication publication);
    List<Publication> getAllPublications();
}