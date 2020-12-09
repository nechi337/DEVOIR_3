package com.dsi33nechi.BookEvent;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dsi33nechi.BookEvent.entites.Booking;
import com.dsi33nechi.BookEvent.service.BookingService;

@SpringBootApplication
public class BookEventApplication implements CommandLineRunner {
	@Autowired
	BookingService bookingService;

	public static void main(String[] args) {
		SpringApplication.run(BookEventApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookingService.saveBooking(new Booking("Hamza", 2, new Date()));
		bookingService.saveBooking(new Booking("Amine", 2, new Date()));
		bookingService.saveBooking(new Booking("Marwen", 2, new Date()));
		bookingService.saveBooking(new Booking("Montassar", 2, new Date()));
		
	}

}
