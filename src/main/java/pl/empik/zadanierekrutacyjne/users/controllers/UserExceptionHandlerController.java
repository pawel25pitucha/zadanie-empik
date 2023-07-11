package pl.empik.zadanierekrutacyjne.users.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.empik.zadanierekrutacyjne.users.services.exception.UserDoesNotExistException;

import java.io.IOException;



@ControllerAdvice
public class UserExceptionHandlerController extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(UserExceptionHandlerController.class);

    @ExceptionHandler(value = {UserDoesNotExistException.class})
    protected ResponseEntity<String> handleUserDoesNotExistException(UserDoesNotExistException ex) {
        log.info(ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = {IOException.class})
    protected ResponseEntity<String> handleErrorException(IOException e) {
        log.error(e.getMessage());
        return ResponseEntity.internalServerError().build();
    }
}
