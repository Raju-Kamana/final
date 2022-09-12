package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.exception.BookNotFoundException;
import com.demo.model.Book;
import com.demo.model.EmailDetails;
import com.demo.repository.BookRepository;

	@Service
	public class BookService {
		@Autowired
		private BookRepository repo;
		
		@Autowired
		EmailServiceImpl mail;
		
		public Book createBook(Book m) {
			return repo.save(m);
		}
		
		
		public List<Book> getAllBooks() {
			return repo.findAll();
		}
		
		public Book getBookById(int id) throws Exception {
			Optional<Book> optional = repo.findById(id);
			if(optional.isEmpty()) {
				System.out.println("Book with id ("+id+") not found in db");
				throw new BookNotFoundException("Book with id ("+id+") not found in db");
			} else {
				return optional.get();
			}
		}
		
		public List<Book> getBooksByName(String name) {
			System.out.println("Finding by name : "+name);
			if(name!=null && name.length()!=0) {
				return repo.findByBookName(name);
			} else {
				return getAllBooks();
			}
		}
		
		public Book subscribeBook(int id) {		
			Optional<Book> optional = repo.findById(id);
			Book b=optional.get();
			b.setSubscription(1);
			b.setMailid("rajukamana01@gmail.com");
			b.setUserid(2);
			 return repo.save(b);							
		}
		
		public Book unsubscribeBook(int id) {		
			Optional<Book> optional = repo.findById(id);
			Book b=optional.get();
			b.setSubscription(0);
			b.setMailid("");
			b.setUserid(0);
			 return repo.save(b);							
		}
		
		public Book blockBook(int id) {
			Optional<Book> optional = repo.findById(id);
			Book b=optional.get();
			EmailDetails det=new EmailDetails();
			det.setMsgBody("Your subscription Book ["+b.getName()+"] is Blocked by Author. Please Check that");
			det.setRecipient(b.getMailid());
			det.setSubject("Book ["+b.getName()+"] is Blocked");
			try {
				mail.sendSimpleMail(det);
				}catch(Exception e) {
					e.printStackTrace();
				}
			b.setBlock(1);
			b.setMailid("");
			b.setSubscription(0);
			b.setUserid(0);
			
			
			 return repo.save(b);			
		}
		
		public Book unblockBook(int id) {
			Optional<Book> optional = repo.findById(id);
			Book b=optional.get();
			b.setBlock(0);				
			//b.setMailid("rajukamana01@gmail.com");
			//b.setSubscription(0);
			//b.setUserid(2);
			 return repo.save(b);			
		}
	
		
		
		
}
