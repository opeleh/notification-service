package io.opeleh.notificationservice.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NotificationMessage {

    private String Msg;  //message to be send

    private String toAddress; //reciever address, could be email, sms or any as implemented in the future

    private String fromAddress; //sender Address, could be email, sms or any as implemented in the future
}
