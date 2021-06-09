package io.opeleh.notificationservice.exception;

public class HttpRequestException extends RuntimeException{

    public HttpRequestException(String message) {
        super(message);
    }

    public HttpRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
