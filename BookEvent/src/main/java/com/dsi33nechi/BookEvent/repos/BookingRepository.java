package com.dsi33nechi.BookEvent.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dsi33nechi.BookEvent.entites.Booking;
import com.dsi33nechi.BookEvent.entites.Event;


public interface BookingRepository extends JpaRepository<Booking, Long>  {
	List<Booking> findByNomClient(String nom);
	List<Booking> findByNomClientContains(String nom);
	@Query("select p from Booking p where p.nomClient like %?1 and p.nombre > ?2")
	List<Booking> findByNomNombre (String nom, int nombre);
	
	@Query("select p from Booking p where p.events = ?1")
	List<Booking> findByEvent (Event events);
	
	List<Booking> findByEventIdEvent(Long id);
	
	List<Booking> findByOrderByNomClientAsc();
	
	@Query("select p from Booking p order by p.nomClient ASC, p.nombre DESC")
	List<Booking> trierBookingsNomsNombre();
	
	
}
