package com.example.rahul.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {
	String apiUrl="http://www.omdbapi.com/?i=tt3896198&apikey=c650971f&t=";
	
	public String getMovieRating(String title) {
		try {
			RestTemplate template = new RestTemplate();
			
			ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl+title, ObjectNode.class);
			ObjectNode jesonObject = response.getBody();
			
			System.out.println(jesonObject.path("imdbRating").asText());
			
			return jesonObject.path("imdbRating").asText();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Api Server is down or "+e.getMessage());
			return null;
		}
		
	}
}
