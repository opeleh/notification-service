package io.opeleh.notificationservice.services;

import io.opeleh.notificationservice.abstrations.MessageGatewayInterface;
import io.opeleh.notificationservice.entities.NotificationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailMessageGateway implements MessageGatewayInterface {

    public void sendMessage(NotificationMessage message, HttpHeaders requestHeaders, String requestURl) {
        log.info("Email Gateway not ready");
    }
}
