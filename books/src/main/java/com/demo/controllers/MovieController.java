package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://hoppscotch.io", "http://localhost:4200"})
@RequestMapping("/movies")
public class MovieController {
	
	List<String> movies = new ArrayList<String>();
	
	@PostConstruct
	public void setUp() {
		movies.add("Superman is back");
		movies.add("Hulk is back");
		movies.add("Ironman is back");
		movies.add("Batman is back");
	}

	// anyone
	@GetMapping("")
	public List<String> getMovies() {
		return movies;
	}
	
	// author
	@GetMapping("/director")
	public String forAuthors() {
		return "Only for director";
	}
		
	// author
	@PostMapping("")
	public String saveMovie(@RequestBody String m) {
		System.out.println("Save movie in database");
		movies.add(m);
		return m;
	}
}
