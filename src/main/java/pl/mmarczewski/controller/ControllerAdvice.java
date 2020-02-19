package pl.mmarczewski.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.mmarczewski.exceptions.ReservationNotFoundException;
import pl.mmarczewski.exceptions.RoomNotFoundException;
import pl.mmarczewski.model.Room;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({RoomNotFoundException.class, ReservationNotFoundException.class})
    public ResponseEntity<String> handle(RoomNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
