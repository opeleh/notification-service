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
@ToString
public class NotificationMessage {

    private String message;  //message to be send

    private String toAddress; //reciever address, could be email, sms or any as implemented in the future

    private String fromAddress; //sender Address, could be email, sms or any as implemented in the future
}
