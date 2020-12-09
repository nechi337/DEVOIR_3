package com.dsi33nechi.BookEvent.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dsi33nechi.BookEvent.entites.Booking;
import com.dsi33nechi.BookEvent.entites.Event;

public interface BookingService {
	Booking saveBooking(Booking p);
	Booking updateBooking(Booking p);
	void deleteBooking(Booking p);
	 void deleteBookingById(Long id);
	Booking getBooking(Long id);
	List<Booking> getAllBookings();
	
	Page<Booking> getAllBookingsParPage(int page, int size);

	List<Booking> findByNomClient(String nom);
	List<Booking> findByNomClientContains(String nom);
	List<Booking> findByNomNombre (String nom, int nombre);
	List<Booking> findByEvent (Event events);
	List<Booking> findByEventIdEvent(Long id);
	List<Booking> findByOrderByNomClientAsc();
	List<Booking> trierBookingsNomsNombre();
}
