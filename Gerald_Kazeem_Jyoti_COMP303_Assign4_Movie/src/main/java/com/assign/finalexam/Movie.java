/** 
	Authors -----------
	Gerald Uchie-Okoro - 301064861
	Kazeem Ademola Odukale - 301021750 
	Jyoti Jairath - 301101579
**/
package com.assign.finalexam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="movie")
public class Movie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="movieid")
	private int movieID;
	
	@Column(name="moviename")
	@NotBlank(message = "Movie Name is mandatory")
	private String movieName;
	
	@Column(name="movielanguage")
	@NotNull(message="Please specify a Langiuage for the movie")
	private String movieLanguage;
	
	@Column(name="moviegenre")
	@NotNull(message="Please specify a Genre for the movie")
	private String movieGenre;
	
	@Column(name="movieduration")
	@NotNull(message="Please enter duration for the movie")
	private String movieDuration;
	
	@Column(name="price")
	@Digits(integer = 6, fraction = 2, message = "Price must have maximum 2 decimals")
	private double price;
	
	public Movie() 
	{
		super();
	}

	public Movie(int movieID, @NotBlank(message = "Movie Name is mandatory") String movieName, String movieLanguage,
			String movieGenre, String movieDuration,
			@Digits(integer = 6, fraction = 2, message = "Price must have maximum 2 decimals") double price) {
		super();
		this.movieID = movieID;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieGenre = movieGenre;
		this.movieDuration = movieDuration;
		this.price = price;
	}

	public Movie(@NotBlank(message = "Movie Name is mandatory") String movieName, String movieLanguage,
			String movieGenre, String movieDuration,
			@Digits(integer = 6, fraction = 2, message = "Price must be like this 0.00") double price) {
		super();
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieGenre = movieGenre;
		this.movieDuration = movieDuration;
		this.price = price;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	

}
