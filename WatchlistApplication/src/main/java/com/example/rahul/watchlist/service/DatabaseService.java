package com.example.rahul.watchlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rahul.watchlist.entity.Movie;
import com.example.rahul.watchlist.repository.MovieRepository;
@Service
public class DatabaseService {
	@Autowired
	RatingService ratingService;
	@Autowired
	MovieRepository movieRepository;
	
	public void createMovie(Movie movie) {
		String apiRating = ratingService.getMovieRating(movie.getTitle());
		if(apiRating != null) {
			movie.setRating(Float.parseFloat(apiRating));
		}
		
		movieRepository.save(movie);
	}
	
	//fatching all movies
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movie getMovieById(int id) {
		return movieRepository.findById(id).get();
	}

	public void update(Movie movie, Integer id) {
		// TODO Auto-generated method stub
		Movie toBeUpdated = movieRepository.findById(id).get();
		toBeUpdated.setTitle(movie.getTitle());
		toBeUpdated.setComment(movie.getComment());
		toBeUpdated.setRating(movie.getRating());
		toBeUpdated.setPriority(movie.getPriority());
		
		movieRepository.save(toBeUpdated);
	}

	public void deleteMovieById(Integer id) {
		// TODO Auto-generated method stub
		movieRepository.deleteById(id);
		
	}
}
