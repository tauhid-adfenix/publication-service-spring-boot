package com.adfenix.publication.service.publicationservice.models;

import com.adfenix.publication.service.publicationservice.utils.Helper;

public class Publication {
    private String Message;
    private String PublicationDateTime;


    public String getMessage() {
        return Message;
    }

    public String PublicationTime() {
        return PublicationDateTime;
    }

    private Publication(String message){
        this.Message = message;
        this.PublicationDateTime = Helper.getCurrentDateTime();
    }

    public static Publication createInstance(String message){
        return new Publication(message);
    }

    @Override
    public String toString() {
        return this.Message;
    }
}
