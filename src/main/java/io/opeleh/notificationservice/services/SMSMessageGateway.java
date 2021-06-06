package io.opeleh.notificationservice.services;

import io.opeleh.notificationservice.entities.NotificationMessage;

/*
* Implementation of MessageGateway for SMS gateway.
*
*
* @author   Fola Akinbobola
* @since    2021-06-06
* @version  1.0.1
* @company 
*/

public class SMSMessageGateway implements MessageGatewayInterface{

    public void sendMessage(NotificationMessage notificationMessage) {

        System.out.println(notificationMessage);
        
    }
    
}
