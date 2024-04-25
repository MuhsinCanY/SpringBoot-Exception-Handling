package com.example.ExceptionHandlingInRESTAPI.exceptions;

import com.example.ExceptionHandlingInRESTAPI.entity.Kangaroo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ZooExceptionResponse> kangarooExceptionHandler(ZooException zooException) {

        ZooExceptionResponse zooExceptionResponse =
                new ZooExceptionResponse(zooException.getStatus().value(),
                        zooException.getMessage(), System.currentTimeMillis());

        log.error("exception occured ! Exception message = " + zooException.getLocalizedMessage());
        return new ResponseEntity<>(zooExceptionResponse, zooException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ZooExceptionResponse> globalExceptionHandler(Exception exception) {

        ZooExceptionResponse exceptionResponse =
                new ZooExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        exception.getLocalizedMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
