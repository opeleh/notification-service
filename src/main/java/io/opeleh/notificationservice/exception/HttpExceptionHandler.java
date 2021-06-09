package io.opeleh.notificationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(value = {HttpRequestException.class})
    public ResponseEntity <HttpException> handleHttpExceptionHandler(HttpRequestException e){
        HttpException httpException = new HttpException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z" ))
        );

        return new ResponseEntity<>(httpException,HttpStatus.BAD_REQUEST );
    }
}
