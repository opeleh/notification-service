package io.opeleh.notificationservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMessage {

    private String channel;  //message channel

    private String to; //receiver address, could be email, sms or any as implemented in the future

    private String content; // message sent

    @Override
    public String toString() {
        return "{\"messages\":[" +
                "{" +
                "\"channel\":\"" + channel + '\"' +
                ", \"to\":\"" + to + '\"' +
                ", \"content\":\"" + content + '\"' +
                "}]}";
    }
}

