package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.advice;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.*;
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

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SchoolDoNotExistException.class)
    public Map<String, String> handleSchoolDoNotExistException(SchoolDoNotExistException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("School ERROR", exception.getMessage());
        return map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CourseDoNotExistException.class)
    public Map<String, String> handleCourseDoNotExistException(CourseDoNotExistException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("Course ERROR", exception.getMessage());
        return map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(StudentNotExistsException.class)
    public Map<String, String> handleStudentNotExistsException(StudentNotExistsException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("Student ERROR", exception.getMessage());
        return map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(StudentAlreadyExistsException.class)
    public Map<String, String> handleStudentAlreadyExistsException(StudentAlreadyExistsException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("Student ERROR", exception.getMessage());
        return map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SchoolAlreadyExistsException.class)
    public Map<String, String> handleSchoolAlreadyExistsException(SchoolAlreadyExistsException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("School ERROR", exception.getMessage());
        return map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TeacherAlreadyExistsException.class)
    public Map<String, String> handleTeacherAlreadyExistsException(TeacherAlreadyExistsException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("Teacher ERROR", exception.getMessage());
        return map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TeacherDoNotExistException.class)
    public Map<String, String> handleTeacherDoNotExistException(TeacherDoNotExistException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("Teacher ERROR", exception.getMessage());
        return map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PersonNotExistsException.class)
    public Map<String, String> handlePersonNotExistsException(PersonNotExistsException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("Person ERROR", exception.getMessage());
        return map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ClassDoNotExistException.class)
    public Map<String, String> handleClassDoNotExistException(ClassDoNotExistException exception) {
        Map<String, String> map =  new HashMap<>();
        map.put("Class ERROR", exception.getMessage());
        return map;
    }




}
