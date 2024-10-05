package com.thefullstackjourney.spring.hotel_example.data;


import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.thefullstackjourney.spring.hotel_example.data.repository.GuestRepository;
import com.thefullstackjourney.spring.hotel_example.data.repository.ReservationRepository;
import com.thefullstackjourney.spring.hotel_example.data.repository.RoomRepository;
import com.thefullstackjourney.spring.hotel_example.service.RoomReservationService;
import com.thefullstackjourney.spring.hotel_example.service.model.RoomReservation;

@Component
public class CLRunner implements CommandLineRunner {

  private final RoomRepository roomRepository;
  private final GuestRepository guestRepository;
  private final ReservationRepository reservationRepository;
  private final RoomReservationService roomReservationService;


  public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository,
      ReservationRepository reservationRepository, RoomReservationService roomReservationService) {
    this.roomRepository = roomRepository;
    this.guestRepository = guestRepository;
    this.reservationRepository = reservationRepository;
    this.roomReservationService = roomReservationService;
  }

  // @Override
  // // this run method shows all the guests, rooms, and reservations in the database
  // public void run(String... args) throws Exception {
  // System.out.println("*** GUESTS ***");
  // List<Guest> guests = this.guestRepository.findAll();
  // guests.forEach(System.out::println);
  // System.out.println("*** ROOMS ***");
  // List<Room> rooms = this.roomRepository.findAll();
  // rooms.forEach(System.out::println);
  // System.out.println("*** RESERVATIONS ***");
  // List<Reservation> reservations = this.reservationRepository.findAll();
  // reservations.forEach(System.out::println);
  // System.out.println("*** RESERVATIONS BY DATE ***");
  // Date specificDate = Date.valueOf("2023-08-28");
  // System.out.println("Specific SQL Date: " + specificDate);
  // List<Reservation> reservationsByDate =
  // this.reservationRepository.findAllByReservationDate(specificDate);
  // reservationsByDate.forEach(System.out::println);
  // }

  @Override
  // this run method shows all the reservations in the database for a specific date
  public void run(String... args) throws Exception {

    List<RoomReservation> roomsReservations =
        this.roomReservationService.getRoomReservationForDate("2023-08-28");
    System.out.println("*** RESERVATIONS FOR 2023-08-28 ***");
    roomsReservations.forEach(roomsReservation -> {
      if (roomsReservation.getReservationId() == 0) {
        System.out.println("Room: " + roomsReservation.getRoomNumber() + " not reserved");
      } else {
        System.out.println("Room: " + roomsReservation.getRoomNumber() + " reserved By: "
            + roomsReservation.getFirstName() + " " + roomsReservation.getLastName());
      }
    });
  }
}
