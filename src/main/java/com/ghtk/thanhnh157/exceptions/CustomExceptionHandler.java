package com.ghtk.thanhnh157.exceptions;

import com.ghtk.thanhnh157.models.responses.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
        //Create new payload containing exception details
        List<String> errors = new ArrayList<>();
        errors.add(e.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("Bad Request", errors);
        //Return response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handlerNotFoundException(NotFoundException e) {
        //Create new payload containing exception details
        List<String> errors = new ArrayList<>();
        errors.add(e.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("Not Found", errors);
        //Return response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //Create new payload containing exception details
        List<String> errors = new ArrayList<>();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            errors.add(error.getDefaultMessage());
        }
        ErrorResponse errorResponse = new ErrorResponse("Validation Failed", errors);
        //Return response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
