package com.thefullstackjourney.spring.hotel_example.data.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thefullstackjourney.spring.hotel_example.data.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    ArrayList<Guest> findAllByFirstNameIgnoreCase(String firstName);

}
