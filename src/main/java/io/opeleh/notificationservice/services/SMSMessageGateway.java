package io.opeleh.notificationservice.services;

import io.opeleh.notificationservice.abstrations.MessageGatewayInterface;
import io.opeleh.notificationservice.configs.HttpRestClient;
import io.opeleh.notificationservice.exception.HttpRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import io.opeleh.notificationservice.entities.NotificationMessage;
import org.springframework.stereotype.Service;
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
public class SMSMessageGateway implements MessageGatewayInterface {

    @Autowired
    private HttpRestClient restTemplate;

    public void sendMessage(NotificationMessage notificationMessage, HttpHeaders requestHeaders, String requestURL) {

        // log request headers
        log.info("{}", requestHeaders);

        // log request body
        log.info("{}", notificationMessage);

        // create local variable
        ResponseEntity <String> response;

        //Create Http Entity
        HttpEntity<String> entity = new HttpEntity<>(notificationMessage.toString(), requestHeaders);

        // Send Http request
        try {
            response = restTemplate.restTemplate().exchange(requestURL, HttpMethod.POST, entity, String.class);
        }catch (HttpStatusCodeException e){
            log.error("{}", e);
            throw new HttpRequestException("throw Costume Exception");
        }catch (Exception e){
            log.info("{}", e);
            throw new HttpRequestException("throw Costume Exception");
        }
        log.info("{}", response);
    }



}
