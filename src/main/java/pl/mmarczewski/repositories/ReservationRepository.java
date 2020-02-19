package pl.mmarczewski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.mmarczewski.model.Reservation;

import java.util.Optional;
import java.util.Set;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

   @Query(value = "SELECT r.* FROM reservation r WHERE r.guest_id = (SELECT g.id FROM guest g where g.second_name = :secondName)", nativeQuery = true)
   Set<Reservation> findReservationByGuestSecondName(String secondName);

}
