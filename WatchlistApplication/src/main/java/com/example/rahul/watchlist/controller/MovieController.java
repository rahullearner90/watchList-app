package com.example.rahul.watchlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.rahul.watchlist.entity.Movie;
import com.example.rahul.watchlist.service.DatabaseService;

@RestController
public class MovieController {
	@Autowired
	DatabaseService movieService;

	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required=false)Integer id) {		
//		System.out.println(id);	
		String viewName="watchlistItemForm";
		Map<String,Object> model = new HashMap<>();
		
		if(id==null) {
			model.put("MovieEntry", new Movie());
		}else {
			model.put("MovieEntry", movieService.getMovieById(id));
		}
		
		
		return new ModelAndView(viewName, model);
	}
	
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForm(Movie movie) {
		Integer id = movie.getId();
		
		if(id==null) {
			movieService.createMovie(movie);
		}else {
			movieService.update(movie, id);
		}
		
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchList() {
		String viewName = "watchlist";
		Map<String,Object> model = new HashMap<>();
		List<Movie> movielist = movieService.getAllMovies();
		
		model.put("watchlistRow", movielist);
		model.put("sizeOfList", movielist.size());
		
		return new ModelAndView(viewName,model);
	}
	
	@GetMapping("/deleteMovie")
	public ModelAndView deleteMovieById(@RequestParam(name="id") Integer id) {
		
		movieService.deleteMovieById(id);
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
