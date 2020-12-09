package com.dsi33nechi.BookEvent.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBooking;
	private String nomClient;
	private int nombre;
	private Date dateReserv;
	
	@ManyToOne
	private Event events;
	
	
	public Event getEvents() {
		return events;
	}


	public void setEvents(Event events) {
		this.events = events;
	}


	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Booking(String nomClient, int nombre, Date dateReserv) {
		super();
		this.nomClient = nomClient;
		this.nombre = nombre;
		this.dateReserv = dateReserv;
	}


	public Long getIdBooking() {
		return idBooking;
	}


	public void setIdBooking(Long idBooking) {
		this.idBooking = idBooking;
	}


	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public int getNombre() {
		return nombre;
	}


	public void setNombre(int nombre) {
		this.nombre = nombre;
	}


	public Date getDateReserv() {
		return dateReserv;
	}


	public void setDateReserv(Date dateReserv) {
		this.dateReserv = dateReserv;
	}


	@Override
	public String toString() {
		return "Booking [idBooking=" + idBooking + ", nomClient=" + nomClient + ", nombre=" + nombre + ", dateReserv="
				+ dateReserv + "]";
	}
	
	
	
	
	
	
}
