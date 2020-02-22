package pl.mmarczewski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.mmarczewski.model.Reservation;
import pl.mmarczewski.model.Room;

import java.util.List;
import java.util.Set;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT r.* FROM room r WHERE r.room_type = :roomType", nativeQuery = true)
    List<Room> findRoomByType(int roomType);

}
