package io.opeleh.notificationservice.services;

import io.opeleh.notificationservice.entities.NotificationMessage;

/*
* Contract to send message using any gateway of choice; SMS, Email or any other
* gateways added in future. They must all implement sendMessage in their specific ways.
*
*
* @author   Fola Akinbobola
* @since    2021-06-06
* @version  1.0.1
* @company  OpelehNG
*/

public interface MessageGatewayInterface {
    
// SendMessage method contract
   void sendMessage (NotificationMessage message);

}
