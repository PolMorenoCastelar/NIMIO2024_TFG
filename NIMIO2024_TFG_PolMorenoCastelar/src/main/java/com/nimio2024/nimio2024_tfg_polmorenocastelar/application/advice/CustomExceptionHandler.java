package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.advice;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CenterAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CenterDoNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CenterAlreadyExistsException.class)
    public Map<String, String> handleCenterAlreadyExistsException(CenterAlreadyExistsException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("Center ERROR", exception.getMessage());
        return map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CenterDoNotExistException.class)
    public Map<String, String> handleCenterDoNotExistException(CenterDoNotExistException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("Center ERROR", exception.getMessage());
        return map;
    }



}
