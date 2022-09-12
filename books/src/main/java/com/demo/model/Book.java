package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private double price;
	private String email;// this one dummy
	private int subscription; //1-subscribe , 0-unsubscribe
	private int block;  //1-block , 0-unblock
	private String mailid;//for reader mailid for mail to address
	private int userid; //1-author, 2-reader
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSubscription() {
		return subscription;
	}
	public void setSubscription(int subscription) {
		this.subscription = subscription;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Book(String name, String author, double price, String email, int subscription, int block,String mailid,int userid) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.email = email;
		this.subscription = subscription;
		this.block = block;
		this.mailid = mailid;
		this.userid = userid;
	}
	
	public Book(int id, String name, String author, double price, String email, int subscription, int block,String mailid,int userid) {
		this(name,author,price,email,subscription,block,mailid,userid);
		this.id = id;		
	}
	
	
	
}
