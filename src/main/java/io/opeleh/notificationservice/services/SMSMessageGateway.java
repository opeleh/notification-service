package io.opeleh.notificationservice.services;

import io.opeleh.notificationservice.configs.HttpRestClient;
import io.opeleh.notificationservice.exception.HttpRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import io.opeleh.notificationservice.entities.NotificationMessage;
import org.springframework.web.client.HttpStatusCodeException;

/*
* Implementation of MessageGateway for SMS gateway.
*
* @author   Fola Akinbobola
* @since    2021-06-06
* @version  1.0.1
* @company  opelehng.io
*
*/
@Service
@Slf4j
public class SMSMessageGateway implements MessageGatewayInterface{

    @Autowired
    private HttpRestClient restClient;

    public void sendMessage(NotificationMessage notificationMessage, HttpHeaders requestHeaders, String requestURL) {
        log.info("{}", requestHeaders);
        log.info("{}", notificationMessage);
        ResponseEntity <String> response;
        HttpEntity<String> entity = new HttpEntity<>(notificationMessage.toString(), requestHeaders);
        try {
            response = restClient.restTemplate().postForEntity(requestURL,entity,String.class);
        }catch (HttpStatusCodeException e){
            log.error("{}", e);
            throw new HttpRequestException("throw Costume Exception");
        }catch (Exception e){
            log.info("{}", e);
            throw new HttpRequestException("throw Costume Exception");
        }

    }



}
