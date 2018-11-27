package com.lib.service;

import java.util.List;

import com.lib.beans.Book;
import com.lib.beans.Subject;

public interface ApplicationService {
	
	Subject searchSubject(int subId);
	Book searchBook(int bookId);
	String deleteSubject(int subId);
	String deleteBook(int bookId);
	String addSubject(Subject sub);	
	String addBook(Book book);
	List<Book> searchByTitle(String bookTitle);
	List<Subject> searchByDuration(int duration);
}
