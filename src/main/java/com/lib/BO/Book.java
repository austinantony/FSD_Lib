package com.lib.BO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
@NamedQueries({ @NamedQuery(name = "findBookByTitle", query = "from Book where LOWER(title) = LOWER(:bookTitle)") })
public class Book{

	@Id
	@Column(name = "BOOK_ID", nullable=false, unique=true)
	private int bookId;
	
	@Column(name = "TITLE", nullable=true, unique=false)
	private String title;
	
	@Column(name = "PRICE", nullable=true, unique=false)
	private double price;
	
	@Column(name = "VOLUME", nullable=true, unique=false)
	private int volume;
	
	@Column(name = "PUBLISH_DATE", nullable=true, unique=false)
	private Date publishedDate;
	
	@Column(name = "REC_CREATED_DATE", nullable=true, unique=false)
	private Date recordCreated = new Date();
	
	@Column(name = "REC_MODIFIED_DATE", nullable=true, unique=false)
	private Date recordModified = new Date();
	
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
	public Date getRecordCreated() {
		return recordCreated;
	}
	public void setRecordCreated() {
		this.recordCreated = new Date();
	}
	public Date getRecordModified() {
		return recordModified;
	}
	public void setRecordModified(Date recordModified) {
		this.recordModified = recordModified;
	}
}
