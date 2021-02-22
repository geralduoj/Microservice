/** 
	Authors -----------
	Gerald Uchie-Okoro - 301064861
	Kazeem Ademola Odukale - 301021750 
	Jyoti Jairath - 301101579
**/
package com.assign.microservice;



import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticketid")
	private int ticketID;
	
	@Column(name="movieticketname")
	@NotNull(message="Please enter name for the movie")
	private String movieName;
	
	@Column(name="customerid")
	@NotNull(message="Please specify a customer id for the movie")
	private int custID;
	
	@Column(name="amountpaid")
	@Digits(integer = 6, fraction = 2, message = "Amount must have maximum 2 decimals")
	@NotNull(message="Please specify an amount paid for the movie")
	private double amountPaid;
	
	@Column(name="numberoftickets")
	@NotNull(message="Please specify number of tickets for the movie")
	private int numberofTicket;
	
	@Column(name="date")
	@Future(message="Date must be in the future")
	//@Pattern(regexp = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|)\\d\\d$", message="Date must be in this format MM/DD/YY")
	@NotNull(message="Please specify date")
	private LocalDate date;
	
	@Column(name="time")
	@NotNull(message="Please specify a Time for the movie")
	@Pattern(regexp="^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", message="Time must be in this format HH:MM and in 24 hour expression")
	private String time;
	
	@Column(name="venue")
	@NotNull(message="Please specify a venue for the movie")
	private String venue;
	
	public Ticket() 
	{
		super();
	}

	public Ticket(int ticketID, @NotNull(message = "Please enter name for the movie") String movieName,
			@NotNull(message = "Please specify a customer id for the movie") int custID,
			@Digits(integer = 6, fraction = 2, message = "Amount must have maximum 2 decimals") @NotNull(message = "Please specify an amount paid for the movie") double amountPaid,
			@NotNull(message = "Please specify number of tickets for the movie") int numberofTicket,
			@Future(message = "Date must be in the future") @Pattern(regexp = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|)\\d\\d", message = "Date must be in this format YYYY-MM-DD") @NotNull(message = "Please specify date") LocalDate date,
			@NotNull(message = "Please specify a Time for the movie") @Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Time must be in this format HH:MM and in 24 hour expression") String time,
			@NotNull(message = "Please specify a venue for the movie") String venue) {
		super();
		this.ticketID = ticketID;
		this.movieName = movieName;
		this.custID = custID;
		this.amountPaid = amountPaid;
		this.numberofTicket = numberofTicket;
		this.date = date;
		this.time = time;
		this.venue = venue;
	}

	public Ticket(@NotNull(message = "Please enter name for the movie") String movieName,
			@NotNull(message = "Please specify a customer id for the movie") int custID,
			@Digits(integer = 6, fraction = 2, message = "Amount must have maximum 2 decimals") @NotNull(message = "Please specify an amount paid for the movie") double amountPaid,
			@NotNull(message = "Please specify number of tickets for the movie") int numberofTicket,
			@Future(message = "Date must be in the future") @Pattern(regexp = "^(19|20)\\d\\d([- /.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$", message = "Date must be in this format YYYY-MM-DD") @NotNull(message = "Please specify date") LocalDate date,
			@NotNull(message = "Please specify a Time for the movie") @Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Time must be in this format HH:MM and in 24 hour expression") String time,
			@NotNull(message = "Please specify a venue for the movie") String venue) {
		super();
		this.movieName = movieName;
		this.custID = custID;
		this.amountPaid = amountPaid;
		this.numberofTicket = numberofTicket;
		this.date = date;
		this.time = time;
		this.venue = venue;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getNumberofTicket() {
		return numberofTicket;
	}

	public void setNumberofTicket(int numberofTicket) {
		this.numberofTicket = numberofTicket;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	
}
