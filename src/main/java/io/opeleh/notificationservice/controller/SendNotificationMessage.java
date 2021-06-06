package io.opeleh.notificationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.opeleh.notificationservice.entities.NotificationMessage;
import io.opeleh.notificationservice.services.SMSMessageGateway;

@RestController
@RequestMapping(path = "message/api/v1/send")
public class SendNotificationMessage {

    @Autowired
    private SMSMessageGateway smsMessageGateway;
   
    @PostMapping
    public ResponseEntity <NotificationMessage> sendMessage(@RequestBody NotificationMessage notificationMessage){
        
        smsMessageGateway.sendMessage(notificationMessage);

        return new ResponseEntity <> (notificationMessage, HttpStatus.CREATED);
    }
    
}
