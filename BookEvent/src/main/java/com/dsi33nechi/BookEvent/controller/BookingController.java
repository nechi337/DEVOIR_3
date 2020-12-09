package com.dsi33nechi.BookEvent.controller;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dsi33nechi.BookEvent.entites.Booking;
import com.dsi33nechi.BookEvent.service.BookingService;
import com.sun.el.parser.ParseException;

@Controller
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createBooking";
	}
	
	
	@RequestMapping("/saveBooking")
	public String saveProduit(@ModelAttribute("booking") Booking booking,
	 @RequestParam("date") String date,
	 ModelMap modelMap) throws 
	ParseException, Throwable
	{
	//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateReserv = dateformat.parse(String.valueOf(date));
		booking.setDateReserv(dateReserv);

	Booking saveBooking = bookingService.saveBooking(booking);
	String msg ="réservation enregistré avec Id "+saveBooking.getIdBooking();
	modelMap.addAttribute("msg", msg);
	return "createBooking";
	}
	
	@RequestMapping("/ListeBooking")
	public String ListeBooking(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Booking> booking = bookingService.getAllBookingsParPage(page, size);
	modelMap.addAttribute("booking", booking);
	 modelMap.addAttribute("pages", new int[booking.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "ListeBooking";
	}

	
	@RequestMapping("/supprimerBooking")
	public String supprimerBooking(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	bookingService.deleteBookingById(id);
	Page<Booking> prods = bookingService.getAllBookingsParPage(page,
	size);
	modelMap.addAttribute("booking", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "ListeBooking";
	}
	
	
	@RequestMapping("/modifierBooking")
	public String editerBooking(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Booking p= bookingService.getBooking(id);
	modelMap.addAttribute("booking", p);
	return "editerBooking";
	}
	@RequestMapping("/updateBooking")
	public String updateBooking(@ModelAttribute("booking") Booking booking,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException, Throwable
	{
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateReserv = dateformat.parse(String.valueOf(date));
		 booking.setDateReserv(dateReserv);

		 bookingService.updateBooking(booking);
		 List<Booking> prods = bookingService.getAllBookings();
		 modelMap.addAttribute("booking", prods);
		return "ListeBooking";
		}

}
