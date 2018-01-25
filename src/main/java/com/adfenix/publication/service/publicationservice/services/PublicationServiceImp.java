package com.adfenix.publication.service.publicationservice.services;

import com.adfenix.publication.service.publicationservice.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PublicationServiceImp implements PublicationService {
    private Map<Object, Object> publicationList = new HashMap<>();

    @Autowired
    private RabbitMqMsgPublisher publisher;

    @Override
    public void sendPublicationToRabbitQueue(Publication publication) {
        String msg = publication.getMessage();
        publisher.send(msg);
        addToPublicationList(publication);
    }

    @Override
    public Map<Object, Object> getAllPublications() {
        return publicationList;
    }

    @Override
    public Map<String, String> getAllPublishedMessages() {
        Map<String,String> messageList = new HashMap<>();
        for(Map.Entry<Object, Object> entry : publicationList.entrySet()) {
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            messageList.put(key, value.toString());
        }
        return messageList;
    }

    private void addToPublicationList(Publication publication) {
        this.publicationList.put(getCurrentDateTime(), publication);
    }

    private String getCurrentDateTime(){
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd 'at' hh:mm:ss a':'";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        return dateFormat.format(date);
    }
}
