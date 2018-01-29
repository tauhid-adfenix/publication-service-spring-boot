package com.adfenix.publication.service.publicationservice.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    private static final String PUBLISH_DATA_JSON_PATTERN = "{\"message\" : \"$data\"}";

    public static String getCurrentDateTime(){
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd 'at' hh:mm:ss a':'";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        return dateFormat.format(date);
    }

    public static String formatPublishString(String data) {
        return PUBLISH_DATA_JSON_PATTERN.replace("$data",data);
    }
}
