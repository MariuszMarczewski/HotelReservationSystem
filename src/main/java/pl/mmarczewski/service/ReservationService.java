package pl.mmarczewski.service;

import org.springframework.stereotype.Service;
import pl.mmarczewski.exceptions.ReservationNotFoundException;
import pl.mmarczewski.model.Reservation;
import pl.mmarczewski.repositories.ReservationRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Long addReservation(Reservation reservation) {
        return reservationRepository.save(reservation).getId();
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationByReservationId(Long id) {
        if (id != null) {
            return reservationRepository.getOne(id);
        }
        throw new ReservationNotFoundException("id cannot be null");
    }

    public Set<Reservation> getReservationByGuestSecondName(String secondName) {
        if (secondName != null) {
            return reservationRepository.findReservationByGuestSecondName(secondName);
        }
        return new HashSet<>(reservationRepository.findAll());
    }

    public Set<Reservation> findAll(){
        return new HashSet<>(reservationRepository.findAll());
    }

}
