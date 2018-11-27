package com.lib.beans;

import java.util.Date;

public class Book {

	private int bookId;
	private String title;
	private double price;
	private int volume;
	private Date publishedDate;
	private Date recardCreatedDate;
	private Date recardModDate;
	
	public Date getRecardCreatedDate() {
		return recardCreatedDate;
	}

	public void setRecardCreatedDate(Date recardCreatedDate) {
		this.recardCreatedDate = recardCreatedDate;
	}

	public Date getRecardModDate() {
		return recardModDate;
	}

	public void setRecardModDate(Date recardModDate) {
		this.recardModDate = recardModDate;
	}

	public Book() {}

	public Book(int id, String title, double price, int volume, Date pubDate) {
		super();
		this.bookId = id;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishedDate = pubDate;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	@Override
	public String toString() {
		return "Book Id : " + this.bookId + ", Title : " + this.title +
				", Price : " + this.price + ", Volume : " + this.volume + ", Published : " + this.publishedDate;
	}
}
