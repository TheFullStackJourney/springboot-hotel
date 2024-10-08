package com.thefullstackjourney.spring.hotel_example.web.api;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.thefullstackjourney.spring.hotel_example.data.entity.Room;
import com.thefullstackjourney.spring.hotel_example.data.repository.RoomRepository;
import com.thefullstackjourney.spring.hotel_example.web.exception.BadRequestException;
import com.thefullstackjourney.spring.hotel_example.web.exception.NotFoundException;


@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {
    private final RoomRepository roomRepository;

    public RoomApiController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping() // default route for GET "/api/rooms"
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    @PostMapping() // route for POST "/api/rooms"
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody Room room) {
        return this.roomRepository.save(room);
    }

    @GetMapping("/{id}") // route for GET "/api/rooms/{id}"
    public Room getSingleRoom(@PathVariable("id") long id) {
        Optional<Room> room = this.roomRepository.findById(id);
        if (room.isPresent()) {
            return room.get();
        } else {
            throw new NotFoundException("Room not found - ID: " + id);
        }
    }

    @PutMapping("/{id}") // route for PUT "/api/rooms/{id}"
    public Room updateRoom(@PathVariable("id") long id, @RequestBody Room room) {
        System.out.println(" ID: " + id);
        System.out.println("Room ID: " + room.getId());

        // input data check
        if (room.getId() != id) {
            throw new BadRequestException("Room ID mismatch. Id in path does not match id in body");
        }
        Room updatedRoom = this.roomRepository.save(room);
        return updatedRoom;
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable("id") long id) {
        this.roomRepository.deleteById(id);
    }
}
