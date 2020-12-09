package com.dsi33nechi.BookEvent.entites;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvent;
	private String nomEvent;
	private Date dateEvent;
	
	@JsonIgnore
	@OneToMany(mappedBy = "events")
	private List<Booking> bookings ;

}