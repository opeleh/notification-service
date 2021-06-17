package io.opeleh.notificationservice.processors.factories;

import io.opeleh.notificationservice.processors.contracts.MessageGatewayInterface;
import io.opeleh.notificationservice.processors.implementations.EmailMessageGateway;
import io.opeleh.notificationservice.processors.implementations.SMSMessageGateway;
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
