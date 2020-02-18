package pl.mmarczewski.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mmarczewski.model.Reservation;
import pl.mmarczewski.service.ReservationService;

import java.util.Set;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
public class Controller {

    private final ReservationService reservationService;

    public Controller(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservations", produces = "application/json")
    Set<Reservation> reservations(@RequestParam(required = false) String secondName){
        return reservationService.getReservationByGuestSecondName(secondName);
    }

    @DeleteMapping("/reservation/delete/{id}")
    public ResponseEntity<Void> removeReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return noContent().build();
    }

    @PostMapping(value = "/reservation/add", consumes = "application/json")
    public ResponseEntity<Long> addBook(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.CREATED);
    }
}
