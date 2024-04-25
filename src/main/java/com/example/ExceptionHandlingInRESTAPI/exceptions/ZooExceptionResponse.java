package com.example.ExceptionHandlingInRESTAPI.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ZooExceptionResponse {

    private int status;
    private String message;
    private long timestamp;
}
