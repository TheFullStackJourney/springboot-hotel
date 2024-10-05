package com.thefullstackjourney.spring.hotel_example.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.thefullstackjourney.spring.hotel_example.data.entity.Guest;
import com.thefullstackjourney.spring.hotel_example.data.entity.Reservation;
import com.thefullstackjourney.spring.hotel_example.data.entity.Room;
import com.thefullstackjourney.spring.hotel_example.data.repository.GuestRepository;
import com.thefullstackjourney.spring.hotel_example.data.repository.ReservationRepository;
import com.thefullstackjourney.spring.hotel_example.data.repository.RoomRepository;
import com.thefullstackjourney.spring.hotel_example.service.model.RoomReservation;
import io.micrometer.common.util.StringUtils;



@Service
public class RoomReservationService {

    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public RoomReservationService(RoomRepository roomRepository,
            ReservationRepository reservationRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
    }

    public List<RoomReservation> getRoomReservationForDate(String reservationDate) {
        Date date = null;
        if (StringUtils.isNotEmpty(reservationDate)) {
            // we assume the reservationDate is in the format yyyy-MM-dd
            // we handle that upstream ...
            date = Date.valueOf(reservationDate);
        } else {
            date = new Date(System.currentTimeMillis());
        }
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();

        List<Room> rooms = this.roomRepository.findAll();

        // create a room reservation for each room
        // the room reservation will later by populated with the reservation details if any
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });

        // get all reservations for the date
        List<Reservation> reservations = this.reservationRepository.findAllByReservationDate(date);
        reservations.forEach(System.out::println);

        // populate the room reservation with the reservation details
        reservations.forEach(reservation -> {
            long roomId = reservation.getRoomId();
            RoomReservation roomReservation = roomReservationMap.get(roomId);
            roomReservation.setReservationId(reservation.getId());
            roomReservation.setReservationDate(reservation.getReservationDate().toString());
            Optional<Guest> guest = this.guestRepository.findById(reservation.getGuestId());
            // throws NoSuchElementException if guest is not found
            roomReservation.setGuestId(guest.get().getId());
            roomReservation.setFirstName(guest.get().getFirstName());
            roomReservation.setLastName(guest.get().getLastName());
        });

        return roomReservationMap.values().stream().toList();
    }


}


