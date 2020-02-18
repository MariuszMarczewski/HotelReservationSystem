package pl.mmarczewski.service;

import pl.mmarczewski.model.Reservation;
import pl.mmarczewski.repositories.ReservationRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Long addReservation(Reservation reservation){
        return reservationRepository.save(reservation).getId();
    }

    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }

//    public Set<Reservation> getReservationByReservationId(Long id){
//        if (id != null) {
//            return reservationRepository.findById(id);
//        }
//        return reservationRepository.findAll();
//    }

    public Set<Reservation> getReservationByGuestSecondName(String secondName){
       if (secondName != null){
           return reservationRepository.findReservationByGuestSecondName(secondName);
       }
       return new HashSet<>(reservationRepository.findAll());
    }

}
