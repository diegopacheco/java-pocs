package com.diegopacheco.pgrustfun.error;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ErrorResponseException.class)
    ResponseEntity<ApiError> handleErrorResponse(ErrorResponseException exception) {
        int status = exception.getStatusCode().value();
        String error = HttpStatus.valueOf(status).getReasonPhrase();
        return ResponseEntity.status(status).body(new ApiError(status, error, exception.getBody().getDetail()));
    }

    @ExceptionHandler(DataAccessException.class)
    ResponseEntity<ApiError> handleDataAccess(DataAccessException exception) {
        Throwable rootCause = exception.getMostSpecificCause();
        String message = rootCause == null ? exception.getMessage() : rootCause.getMessage();
        return ResponseEntity.badRequest().body(new ApiError(400, HttpStatus.BAD_REQUEST.getReasonPhrase(), message));
    }
}

