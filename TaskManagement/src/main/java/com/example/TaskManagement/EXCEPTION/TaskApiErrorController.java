package com.example.TaskManagement.EXCEPTION;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskApiErrorController {

    @ExceptionHandler(RecordNotFoundException.class)
    public ProblemDetail handleRecordNotFoundError(RecordNotFoundException ex) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        response.setDetail(ex.getMessage());
        return response;
    }
    @ExceptionHandler(NullException.class)
    public ProblemDetail handleNullError(NullException ex) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.NOT_ACCEPTABLE);
        response.setDetail(ex.getMessage());
        return response;
    }
}

