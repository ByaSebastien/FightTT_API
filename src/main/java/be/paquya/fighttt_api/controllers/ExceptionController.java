package be.paquya.fighttt_api.controllers;

import be.paquya.fighttt_api.exceptions.FightTTException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({FightTTException.class,RuntimeException.class})
    public ResponseEntity<Object> handlePrecondition(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handlePrecondition(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
