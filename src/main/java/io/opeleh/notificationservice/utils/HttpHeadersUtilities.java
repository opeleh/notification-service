package io.opeleh.notificationservice.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class HttpHeadersUtilities {

    @Value("${Authorization}")
    private String Authorization_key;

    public HttpHeaders getHeaders(){

        //  set Headers for the request
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",Authorization_key);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return  headers;
    }

}
