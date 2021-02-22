/** 
	Authors -----------
	Gerald Uchie-Okoro - 301064861
	Kazeem Ademola Odukale - 301021750 
	Jyoti Jairath - 301101579
**/
package com.assign.finalexam;

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
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepo;
	
	
	@RequestMapping(value = "/newmovie")
    public ModelAndView newMovie(Movie movie)
    {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("newmovie");
		return mv;
    }
	
	@RequestMapping(value = "/movies")
    public ModelAndView movies()
    {
		ModelAndView mv = new ModelAndView();
		mv.addObject("movie", movieRepo.findAll());
		mv.setViewName("movies");
		return mv;
    }
	
	//add a new Movie
		@PostMapping("/addmovie")
		    public String add(@Valid Movie movie, BindingResult result, Model model) {
		        if (result.hasErrors()) {
		            return "newmovie";
		        }

		        movieRepo.save(movie);
		        model.addAttribute("movie", movieRepo.findAll());
		        return "movies";
		    }
		
		//Get the edit request
				@GetMapping("/editmovie/{movieID}")
				public String edit(@PathVariable("movieID") int movieID, Model model) {
				    Movie movie = movieRepo.findById(movieID)
				      .orElseThrow(() -> new IllegalArgumentException("Invalid Movie number:" + movieID));

				    model.addAttribute("movie", movie);
				    return "update-movie";
				}
				
				
				//update the existing movie
				@PostMapping("/updatemovie/{id}")
				public String update(@PathVariable("id") int no, @Valid Movie movie,
				  BindingResult result, Model model) {
				    if (result.hasErrors()) {
				    	movie.setMovieID(no);
				        return "update-movie";
				    }
				    Movie movieToUpdate = movieRepo.getOne(no);
				    movieToUpdate.setMovieName(movie.getMovieName());
				    movieToUpdate.setMovieLanguage(movie.getMovieLanguage());
				    movieToUpdate.setMovieGenre(movie.getMovieGenre());
				    movieToUpdate.setMovieDuration(movie.getMovieDuration());
				    movieToUpdate.setPrice(movie.getPrice());
				    movieRepo.save(movieToUpdate);

				    model.addAttribute("movie", movieRepo.findAll());
				    return "movies";
				}
				
				//delete a customer
				@GetMapping("/deletemovie/{id}")
				public String delete(@PathVariable("id") int no, Model model) {
				    Movie movie = movieRepo.findById(no)
				      .orElseThrow(() -> new IllegalArgumentException("Invalid Movie ID Number:" + no));
				    movieRepo.delete(movie);
				    model.addAttribute("movie", movieRepo.findAll());
				    return "movies";
				}
				
	/**
	@PostMapping("/addmovie")
    public @ResponseBody ModelAndView add(@RequestParam("movieName") String movieName,
            @RequestParam("movieDuration") String movieDuration,
            @RequestParam("movieGenre") String movieGenre,
            @RequestParam("movieLanguage") String movieLanguage,
            @RequestParam("price") double price)
    {
		Movie movie=new Movie(movieName,movieLanguage,movieGenre,movieDuration,price);
		movieRepo.save(movie);
		ModelAndView mv = new ModelAndView();
		mv.addObject("movie", movieRepo.findAll());
		mv.setViewName("movies");
		return mv;
    }**/

}
