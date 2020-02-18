package pl.mmarczewski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmarczewski.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
