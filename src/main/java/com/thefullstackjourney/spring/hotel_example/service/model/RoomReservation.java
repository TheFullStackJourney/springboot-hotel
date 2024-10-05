package com.thefullstackjourney.spring.hotel_example.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomReservation {
    private long roomId;
    private String roomName;
    private String roomNumber;
    private long guestId;
    private String firstName;
    private String lastName;
    private long reservationId;
    private String reservationDate; // we use a String here as its easier to work with in the UI

}
