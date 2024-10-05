// package com.thefullstackjourney.spring.hotel_example.service;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertNull;
// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;
// import java.util.Optional;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import com.thefullstackjourney.spring.hotel_example.repository.RoomReservationRepository;
// import com.thefullstackjourney.spring.hotel_example.service.model.RoomReservation;



// public class RoomReservationServiceTest {

// @Mock
// private RoomReservationRepository roomReservationRepository;

// @InjectMocks
// private RoomReservationService roomReservationService;

// @BeforeEach
// public void setUp() {
// MockitoAnnotations.openMocks(this);
// }

// @Test
// public void testGetReservationById() {
// RoomReservation reservation = new RoomReservation();
// reservation.setId(1L);
// when(roomReservationRepository.findById(1L)).thenReturn(Optional.of(reservation));

// RoomReservation result = roomReservationService.getReservationById(1L);
// assertNotNull(result);
// assertEquals(1L, result.getId());
// }

// @Test
// public void testGetReservationById_NotFound() {
// when(roomReservationRepository.findById(1L)).thenReturn(Optional.empty());

// RoomReservation result = roomReservationService.getReservationById(1L);
// assertNull(result);
// }

// @Test
// public void testCreateReservation() {
// RoomReservation reservation = new RoomReservation();
// when(roomReservationRepository.save(reservation)).thenReturn(reservation);

// RoomReservation result = roomReservationService.createReservation(reservation);
// assertNotNull(result);
// verify(roomReservationRepository, times(1)).save(reservation);
// }

// @Test
// public void testDeleteReservation() {
// RoomReservation reservation = new RoomReservation();
// reservation.setId(1L);
// when(roomReservationRepository.findById(1L)).thenReturn(Optional.of(reservation));
// doNothing().when(roomReservationRepository).delete(reservation);

// roomReservationService.deleteReservation(1L);
// verify(roomReservationRepository, times(1)).delete(reservation);
// }
// }
