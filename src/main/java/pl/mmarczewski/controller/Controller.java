package pl.mmarczewski.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mmarczewski.model.Reservation;
import pl.mmarczewski.service.ReservationService;

import javax.websocket.server.PathParam;
import java.util.Optional;
import java.util.Set;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
public class Controller {

    private final ReservationService reservationService;

    public Controller(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservations/{secondName}", produces = "application/json")
    Set<Reservation> reservationsByName(@RequestParam(required = false) String secondName){
        return reservationService.getReservationByGuestSecondName(secondName);
    }

    @GetMapping(value = "/reservations/{id}", produces = "application/json")
    Optional<Reservation> reservationsById(@RequestParam(required = false) Long id){
        return reservationService.getReservationByReservationId(id);
    }

    @DeleteMapping("/reservation/delete/{id}")
    public ResponseEntity<Void> removeReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return noContent().build();
    }

    @PostMapping(value = "/reservation/add", consumes = "application/json")
    public ResponseEntity<Long> add(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.CREATED);
    }

    @PutMapping(value = "/reservation/update", consumes = "application/json")
    public void update(@PathParam("id") Long id, Reservation reservation){
        reservationService.updateReservation(id, reservation);
    }
}
