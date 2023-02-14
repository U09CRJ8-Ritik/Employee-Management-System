package com.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {

        HashMap<String, Object> map = new HashMap<>();

        map.put("message", ex.getMessage());
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        map.put("Date", LocalDate.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methodArgumentNotValid(MethodArgumentNotValidException ex) {

        HashMap<String, Object> map = new HashMap<>();

        map.put("message", "Invalid Data");
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        map.put("Date", LocalDate.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @ExceptionHandler(DataNegativeException.class)
    public ResponseEntity<Map<String, Object>> handleDataNegativeException(DataNegativeException ex) {

        HashMap<String, Object> map = new HashMap<>();

        map.put("message", ex.getMessage());
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        map.put("Date", LocalDate.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidDateException(InvalidDateException ex) {

        HashMap<String, Object> map = new HashMap<>();

        map.put("message", ex.getMessage());
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        map.put("Date", LocalDate.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @ExceptionHandler(DateOfBirthInNegativeException.class)
    public ResponseEntity<Map<String, Object>> handleDateOfBirthInNegativeException(DateOfBirthInNegativeException ex) {

        HashMap<String, Object> map = new HashMap<>();

        map.put("message", ex.getMessage());
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        map.put("Date", LocalDate.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
