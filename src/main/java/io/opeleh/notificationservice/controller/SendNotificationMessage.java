package io.opeleh.notificationservice.controller;

import io.opeleh.notificationservice.abstrations.MessageGatewayInterface;
import io.opeleh.notificationservice.factories.MessageGatewayFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.opeleh.notificationservice.entities.NotificationMessage;
import io.opeleh.notificationservice.services.SMSMessageGateway;

import java.util.Collections;

/*
 * Implementation of SendNotificationMessage controller.
 *
 * @author   Fola Akinbobola
 * @since    2021-06-06
 * @version  1.0.1
 * @company  opelehng.io
 *
 */

@Slf4j
@RestController
@RequestMapping(path = "message/api/v1/send")
public class SendNotificationMessage {


    @Autowired
    private MessageGatewayFactory messageGatewayFactory;

    @Value("${Authorization}")
    private String Authorization_key;



    private MessageGatewayInterface messageGatewayInterface;
   
    @PostMapping (path ="{gateway}")
    public ResponseEntity <NotificationMessage> sendMessage(@RequestBody NotificationMessage notificationMessage, @PathVariable String gateway){

        //  set Headers for the request
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",Authorization_key);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // request endpoint
        String requestURl = "https://platform.clickatell.com/v1/message";

        messageGatewayInterface = messageGatewayFactory.createMessageGateway(gateway);

        // call smsMessageGateway
        messageGatewayInterface.sendMessage(notificationMessage, headers, requestURl);

        // return notification Message as response
        return new ResponseEntity<>(notificationMessage, HttpStatus.CREATED);
    }
    
}
