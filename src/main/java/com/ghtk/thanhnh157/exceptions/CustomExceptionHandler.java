package com.ghtk.thanhnh157.exceptions;

import com.ghtk.thanhnh157.models.responses.CommonResponse;
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
        List<String> errors = new ArrayList<>();
        errors.add(e.getLocalizedMessage());
        CommonResponse errorResponse = new CommonResponse(false, "Bad request!", null, errors);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handlerNotFoundException(NotFoundException e) {
        List<String> errors = new ArrayList<>();
        errors.add(e.getLocalizedMessage());
        CommonResponse errorResponse = new CommonResponse(false, "Not found!", null, errors);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            errors.add(error.getDefaultMessage());
        }
        CommonResponse errorResponse = new CommonResponse(false, "Data validation failed!", null, errors);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /*
     * Global Exception Handler
     * */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAllExceptions(Exception e) {
        List<String> errors = new ArrayList<>();
        errors.add(e.getLocalizedMessage());
        CommonResponse errorResponse = new CommonResponse(false, "Error occured! :(", null, errors);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
