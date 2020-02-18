package pl.mmarczewski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmarczewski.model.Reservation;

import java.util.Optional;
import java.util.Set;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

   Set<Reservation> findReservationByGuestSecondName(String secondName);

}
