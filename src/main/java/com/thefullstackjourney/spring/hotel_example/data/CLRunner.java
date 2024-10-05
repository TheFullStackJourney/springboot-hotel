package com.thefullstackjourney.spring.hotel_example.data;


import java.sql.Date;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.thefullstackjourney.spring.hotel_example.data.entity.Guest;
import com.thefullstackjourney.spring.hotel_example.data.entity.Reservation;
import com.thefullstackjourney.spring.hotel_example.data.entity.Room;
import com.thefullstackjourney.spring.hotel_example.data.repository.GuestRepository;
import com.thefullstackjourney.spring.hotel_example.data.repository.ReservationRepository;
import com.thefullstackjourney.spring.hotel_example.data.repository.RoomRepository;

@Component
public class CLRunner implements CommandLineRunner {

  private final RoomRepository roomRepository;
  private final GuestRepository guestRepository;
  private final ReservationRepository reservationRepository;



  public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository,
      ReservationRepository reservationRepository) {
    this.roomRepository = roomRepository;
    this.guestRepository = guestRepository;
    this.reservationRepository = reservationRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("*** GUESTS ***");
    List<Guest> guests = this.guestRepository.findAll();
    guests.forEach(System.out::println);
    System.out.println("*** ROOMS ***");
    List<Room> rooms = this.roomRepository.findAll();
    rooms.forEach(System.out::println);
    System.out.println("*** RESERVATIONS ***");
    List<Reservation> reservations = this.reservationRepository.findAll();
    reservations.forEach(System.out::println);
    System.out.println("*** RESERVATIONS BY DATE ***");
    Date specificDate = Date.valueOf("2023-08-28");
    System.out.println("Specific SQL Date: " + specificDate);
    List<Reservation> reservationsByDate =
        this.reservationRepository.findAllByReservationDate(specificDate);
    reservationsByDate.forEach(System.out::println);
  }
}
