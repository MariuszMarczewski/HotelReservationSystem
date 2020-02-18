package pl.mmarczewski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmarczewski.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
