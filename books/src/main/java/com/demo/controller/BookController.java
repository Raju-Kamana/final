package com.demo.controller;

import java.net.URI;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.model.Book;
import com.demo.service.BookService;

@RestController
//@CrossOrigin(origins = {"http://localhost:8082", "http://localhost:8082"})
@RequestMapping("/books")


@CrossOrigin(origins = {"https://hoppscotch.io", "http://localhost:4200"})
//@RequestMapping("/api/v1/author")

public class BookController {
	
	@Autowired
	private BookService service;

	@PostConstruct
	public void setUp() {
		service.createBook(new Book("Python", "Raju",100,"raju@gmail.com",1,0,"rajukamana01@gmail.com",2));
		service.createBook(new Book("Java", "Mani",400,"mani@gmail.com",1,0,"rajukamana01@gmail.com",2));
		service.createBook(new Book("Angular","Raj",300,"kamananookaraju@gmail.com", 0,0,"",0));
		service.createBook(new Book("AWS","Nookaraju",300,"kamananookaraju@gmail.com", 0,0,"",0));
	}
	
	@GetMapping("")
	public List<Book> getBooks() {
		return service.getAllBooks();
	}
	
	@PostMapping("")
	public Book saveBook(@RequestBody Book m) {
		return service.createBook(m);
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) throws Exception {
		return service.getBookById(id);
	}
	
	@GetMapping("/name") // ?name="batman is flying"
	public List<Book> getBooksByName(@RequestParam String name){
		return service.getBooksByName(name);
	}
		
	@PostMapping("/reader/subscribe/{id}")
	public void subscribeBook(@PathVariable int id) throws Exception {	
		service.subscribeBook(id);
	}
	
	@PostMapping("/reader/unsubscribe/{id}")
	public void unsubscribeBook(@PathVariable int id) throws Exception {	
		service.unsubscribeBook(id);
	}
	
	@PostMapping("/author/block/{id}")
	public void blockBook(@PathVariable int id) throws Exception {	
		service.blockBook(id);
	}
	
	@PostMapping("/author/unblock/{id}")
	public void unblockBook(@PathVariable int id) throws Exception {	
		service.unblockBook(id);
	}
	

}
