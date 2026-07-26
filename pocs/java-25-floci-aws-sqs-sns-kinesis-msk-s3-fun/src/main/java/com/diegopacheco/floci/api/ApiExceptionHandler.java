package com.diegopacheco.floci.api;

import static com.diegopacheco.floci.api.ApiModels.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import software.amazon.awssdk.awscore.exception.AwsServiceException;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<ErrorResponse> invalidRequest(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(AwsServiceException.class)
    ResponseEntity<ErrorResponse> awsFailure(AwsServiceException exception) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ErrorResponse(exception.awsErrorDetails().errorMessage()));
    }
}
