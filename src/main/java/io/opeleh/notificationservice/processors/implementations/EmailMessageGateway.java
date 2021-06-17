package io.opeleh.notificationservice.processors.implementations;

import io.opeleh.notificationservice.processors.contracts.MessageGatewayInterface;
import io.opeleh.notificationservice.entities.NotificationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailMessageGateway implements MessageGatewayInterface {

    public void sendMessage(NotificationMessage message, HttpHeaders requestHeaders) {
        log.info("Email Gateway not ready");
    }
}
