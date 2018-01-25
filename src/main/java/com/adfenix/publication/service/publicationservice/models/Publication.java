package com.adfenix.publication.service.publicationservice.models;

public class Publication {
    public String Message;


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return this.Message;
    }
}
