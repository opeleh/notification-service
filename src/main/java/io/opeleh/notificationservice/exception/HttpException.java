package io.opeleh.notificationservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class HttpException {

    private final String Message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public HttpException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        Message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return Message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
