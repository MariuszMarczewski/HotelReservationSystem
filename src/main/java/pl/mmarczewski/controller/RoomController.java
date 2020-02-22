package pl.mmarczewski.controller;

import org.springframework.web.bind.annotation.*;
import pl.mmarczewski.model.Room;
import pl.mmarczewski.service.RoomService;

import java.util.List;

@RestController
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = "/rooms" , produces = "application/json" )
    List<Room> findAll(){
      return roomService.findAll();
    }

    @GetMapping(value = "/rooms/type/{roomType}" , produces = "application/json" )
    List<Room> findRoomByType(@PathVariable("roomType") int roomType){
        return roomService.findRoomByType(roomType);
    }
}
