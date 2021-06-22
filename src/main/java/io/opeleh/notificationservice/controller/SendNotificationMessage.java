package io.opeleh.notificationservice.controller;

import io.opeleh.notificationservice.processors.contracts.MessageGatewayInterface;
import io.opeleh.notificationservice.processors.factories.MessageGatewayFactory;
import io.opeleh.notificationservice.utils.HttpHeadersUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.opeleh.notificationservice.entities.NotificationMessage;

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

    @Autowired
    private HttpHeadersUtilities httpHeadersUtilities;

    private MessageGatewayInterface messageGatewayInterface;
   
    @PostMapping
    public ResponseEntity <NotificationMessage> sendMessage(@RequestBody NotificationMessage notificationMessage){

        messageGatewayInterface = messageGatewayFactory.createMessageGateway(notificationMessage.getChannel());

        // call smsMessageGateway
        messageGatewayInterface.sendMessage(notificationMessage, httpHeadersUtilities.getHeaders());

        // return notification Message as response
        return new ResponseEntity<>(notificationMessage, HttpStatus.CREATED);
    }
    
}
