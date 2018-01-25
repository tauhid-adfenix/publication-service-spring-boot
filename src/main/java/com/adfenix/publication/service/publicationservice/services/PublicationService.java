package com.adfenix.publication.service.publicationservice.services;

import com.adfenix.publication.service.publicationservice.models.Publication;
import java.util.Map;

public interface PublicationService {
    void sendPublicationToRabbitQueue(Publication publication);
    Map<Object, Object> getAllPublications();
    Map<String, String> getAllPublishedMessages();
}