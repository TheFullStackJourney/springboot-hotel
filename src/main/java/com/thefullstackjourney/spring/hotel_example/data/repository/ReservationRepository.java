package com.thefullstackjourney.spring.hotel_example.data.repository;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thefullstackjourney.spring.hotel_example.data.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    ArrayList<Reservation> findAllByReservationDate(Date resDate);

}
