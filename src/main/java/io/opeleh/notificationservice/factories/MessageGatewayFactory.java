package io.opeleh.notificationservice.factories;

import io.opeleh.notificationservice.abstrations.MessageGatewayInterface;
import io.opeleh.notificationservice.services.SMSMessageGateway;

public class MessageGatewayFactory {

        public MessageGatewayInterface getMessageGateway(String messageGateway){
            if(messageGateway == null){
                return null;
            }
            if(messageGateway.equalsIgnoreCase("EMAIL")) {
                return new SMSMessageGateway();
            }
            else if(messageGateway.equalsIgnoreCase("SMS")){
                return new SMSMessageGateway();
            }
            return null;
        }

}
