package com.dsi33nechi.BookEvent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dsi33nechi.BookEvent.entites.Booking;
import com.dsi33nechi.BookEvent.entites.Event;
import com.dsi33nechi.BookEvent.repos.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{
		
	@Autowired
	BookingRepository bookingRepository;
	
	
	@Override
	public Booking saveBooking(Booking p) {
	return bookingRepository.save(p);
	}


	@Override
	public Booking updateBooking(Booking p) {
	return bookingRepository.save(p);
	}
	@Override
	public void deleteBooking(Booking p) {
	bookingRepository.delete(p);
	}
	 @Override
	public void deleteBookingById(Long id) {
	bookingRepository.deleteById(id);
	}
	@Override
	public Booking getBooking(Long id) {
	return bookingRepository.findById(id).get();
	}
	@Override
	public List<Booking> getAllBookings() {
	return bookingRepository.findAll();
	}


	@Override
	public Page<Booking> getAllBookingsParPage(int page, int size) {
		return bookingRepository.findAll(PageRequest.of(page, size));
	}


	@Override
	public List<Booking> findByNomClient(String nom) {
		return bookingRepository.findByNomClient(nom);
	}


	@Override
	public List<Booking> findByNomClientContains(String nom) {
		return bookingRepository.findByNomClientContains(nom);
	}


	@Override
	public List<Booking> findByNomNombre(String nom, int nombre) {
		// TODO Auto-generated method stub
		return bookingRepository.findByNomNombre(nom, nombre);
	}


	@Override
	public List<Booking> findByEvent(Event events) {
		// TODO Auto-generated method stub
		return bookingRepository.findByEvent(events);
	}


	@Override
	public List<Booking> findByEventIdEvent(Long id) {
		// TODO Auto-generated method stub
		return bookingRepository.findByEventIdEvent(id);
	}


	@Override
	public List<Booking> findByOrderByNomClientAsc() {
		// TODO Auto-generated method stub
		return bookingRepository.findByOrderByNomClientAsc();
	}


	@Override
	public List<Booking> trierBookingsNomsNombre() {
		// TODO Auto-generated method stub
		return bookingRepository.trierBookingsNomsNombre();
	}
	
}
