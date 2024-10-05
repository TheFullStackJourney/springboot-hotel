package com.thefullstackjourney.spring.hotel_example.data.entity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "reservations")
@Data
@ToString
public class Reservation {

  @Id
  @Column(name = "RESERVATION_ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long reservation_id;

  @Column(name = "ROOM_ID")
  private long room_id;

  @Column(name = "GUEST_ID")
  private long guest_id;

  @Column(name = "RES_DATE")
  private Date reservationDate;
}
