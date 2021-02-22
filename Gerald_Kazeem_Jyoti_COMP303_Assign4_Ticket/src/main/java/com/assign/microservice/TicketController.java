/** 
	Authors -----------
	Gerald Uchie-Okoro - 301064861
	Kazeem Ademola Odukale - 301021750 
	Jyoti Jairath - 301101579
**/
package com.assign.microservice;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketController {
	
	@Autowired
	private TicketRepository ticketRepo;
	
	/**
	@PostMapping("/addticket")
    public @ResponseBody ModelAndView add(@RequestParam("price") double price, @RequestParam("qty") int qty,
    		@RequestParam("custId") int custId, @RequestParam("dateCal") String dateCal, @RequestParam("movieName") String movieName, 
    		@RequestParam("timeCal") String timeCal, @RequestParam("venue") String venue)
    {
		
		double amt = price * qty;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
		LocalDate myObj = LocalDate.parse(dateCal, formatter);
		Date date=Date.valueOf(myObj);
		
		Ticket newTicket = new Ticket(movieName,custId,amt,qty,date,timeCal,venue);
		//Ticket test = newTicket;
		ticketRepo.save(newTicket);
		ModelAndView mv = new ModelAndView();
		mv.addObject("ticks", ticketRepo.findAll());
		mv.setViewName("tickets");
		return mv;
    }*/
	
	@RequestMapping(value = "/tickets")
    public ModelAndView tickets()
    {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ticks", ticketRepo.findAll());
		mv.setViewName("tickets");
		return mv;
    }
	
	@RequestMapping(value = "/order-ticket")
    public ModelAndView orderTicket(Ticket ticket)
    {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("order-ticket");
		return mv;
    }
	
	//add a new Ticket
		@PostMapping("/addticket")
		    public String add(@Valid Ticket ticket, BindingResult result, Model model) {
		        if (result.hasErrors()) {
		            return "order-ticket";
		        }
		        ticketRepo.save(ticket);
		        model.addAttribute("ticks", ticketRepo.findAll());
		        return "tickets";
		    }
		
		//Get the edit request
				@GetMapping("/edit-ticket/{ticketID}")
				public String edit(@PathVariable("ticketID") int ticketID, Model model) {
				    Ticket ticket = ticketRepo.findById(ticketID)
				      .orElseThrow(() -> new IllegalArgumentException("Invalid ticket number:" + ticketID));

				    model.addAttribute("ticket", ticket);
				    return "update-ticket";
				}
				
				
				//update the existing ticket
				@PostMapping("/updateticket/{ticketID}")
				public String update(@PathVariable("ticketID") int ticketID, @Valid Ticket ticket,
				  BindingResult result, Model model) {
				    if (result.hasErrors()) {
				    	ticket.setTicketID(ticketID);
				        return "update-ticket";
				    }
				    Ticket ticketToUpdate = ticketRepo.getOne(ticketID);
				    ticketToUpdate.setMovieName(ticket.getMovieName());
				    ticketToUpdate.setCustID(ticket.getCustID());
				    ticketToUpdate.setAmountPaid(ticket.getAmountPaid());
				    ticketToUpdate.setNumberofTicket(ticket.getNumberofTicket());
				    ticketToUpdate.setDate(ticket.getDate());
				    ticketToUpdate.setTime(ticket.getTime());
				    ticketToUpdate.setVenue(ticket.getVenue());
				    ticketRepo.save(ticketToUpdate);

				    model.addAttribute("ticks", ticketRepo.findAll());
				    return "tickets";
				}
				
				//Get the edit request
				@GetMapping("/delete-ticket/{ticketID}")
				public String delete(@PathVariable("ticketID") int ticketID, Model model) {
				    Ticket ticket = ticketRepo.findById(ticketID)
				      .orElseThrow(() -> new IllegalArgumentException("Invalid customer number:" + ticketID));
				    ticketRepo.delete(ticket);
				    model.addAttribute("ticks", ticketRepo.findAll());
				    return "tickets";
				}
}
