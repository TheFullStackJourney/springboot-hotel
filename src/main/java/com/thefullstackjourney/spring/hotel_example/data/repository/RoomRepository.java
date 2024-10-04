package com.thefullstackjourney.spring.hotel_example.data.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thefullstackjourney.spring.hotel_example.data.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
}
