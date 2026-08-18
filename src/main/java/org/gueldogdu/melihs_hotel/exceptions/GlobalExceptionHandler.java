package org.gueldogdu.melihs_hotel.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Object> handleHotelNotFoundException(HotelNotFoundException ex) {
        return buildExceptionResponseBody(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoomAlreadyBookedException.class)
    public ResponseEntity<Object> handleRoomAlreadyBookedException(RoomAlreadyBookedException ex) {
        return buildExceptionResponseBody(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return buildExceptionResponseBody(errorMessage, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> buildExceptionResponseBody(String message, HttpStatus status) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", status.getReasonPhrase());
        body.put("status", status);
        body.put("message", message);

        return new ResponseEntity<>(body, status);
    }
}
