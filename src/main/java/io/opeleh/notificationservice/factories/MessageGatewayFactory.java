package io.opeleh.notificationservice.factories;

import io.opeleh.notificationservice.abstrations.MessageGatewayInterface;
import io.opeleh.notificationservice.services.EmailMessageGateway;
import io.opeleh.notificationservice.services.SMSMessageGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageGatewayFactory {

    @Autowired
    private EmailMessageGateway emailMessageGateway;

    @Autowired
    private SMSMessageGateway smsMessageGateway;


        public MessageGatewayInterface createMessageGateway(String messageGateway){

            if(messageGateway.equalsIgnoreCase("EMAIL")) {
                return emailMessageGateway;
            }
            else if(messageGateway.equalsIgnoreCase("SMS")){
                return smsMessageGateway;
            }
            return null;
        }

}
