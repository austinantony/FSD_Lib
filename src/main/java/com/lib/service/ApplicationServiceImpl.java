package com.lib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.beans.Book;
import com.lib.beans.Subject;
import com.lib.repository.BookRepository;
import com.lib.repository.SubjectRepository;


@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	public BookRepository bookRepo;
	
	@Autowired
	public SubjectRepository subRepo;
	
	public ApplicationServiceImpl() {
		System.out.println("ApplicationServiceImpl Created");
	}
	
	@Override
	public Subject searchSubject(int subId) {
		Subject sub = new Subject();
		BeanUtils.copyProperties(subRepo.findById(subId).get(), sub);
    	return sub;
	}
	
	@Override
	public Book searchBook(int bookId) {
		Book book = new Book();
		BeanUtils.copyProperties(bookRepo.findById(bookId).get(), book);
		return book;
	}
	
	@Override
	public String deleteSubject(int subId) {
    	subRepo.deleteById(subId);
        return "Subject removed successfully!";
	}
	
	@Override
	public String deleteBook(int bookId) {
       	bookRepo.deleteById(bookId);
		return "Book removed successfully!";
	}
	
	@Override
	public String addSubject(Subject sub) {
		com.lib.BO.Subject subEntity = new com.lib.BO.Subject();
		BeanUtils.copyProperties(sub,subEntity);
		subEntity = subRepo.save(subEntity);
		if(null != subEntity) {
    		return "Subject added successfully!";
    	}
		return "Issue in adding subject";
	}
	
	@Override
	public String addBook(Book book) {
		com.lib.BO.Book bookEntity = new com.lib.BO.Book();
		BeanUtils.copyProperties(book,bookEntity);
		bookEntity = bookRepo.save(bookEntity);
		if(null != bookEntity){
   			return "Book added successfully!";
   		}
		return "Issue in adding Book";
	}
	
	@Override
	public List<Book> searchByTitle(String bookTitle) {
		List<Book> bookList = new ArrayList<>();
		List<com.lib.BO.Book> temp = bookRepo.find(bookTitle);
		temp.forEach(boBook->{
			Book tempBook = new Book();
			tempBook.setBookId(boBook.getBookId());
			tempBook.setTitle(boBook.getTitle());
			tempBook.setPrice(boBook.getPrice());
			tempBook.setVolume(boBook.getVolume());
			tempBook.setPublishedDate(boBook.getPublishedDate());
			bookList.add(tempBook);
		});
		return bookList;
	}
	
	@Override
	public List<Subject> searchByDuration(int duration) {
		List<Subject> subList = new ArrayList<>();
		List<com.lib.BO.Subject> temp = subRepo.find(duration);
		temp.forEach(boSub->{
			Subject tempSub = new Subject();
			tempSub.setSubjectId(boSub.getSubjectId());
			tempSub.setSubjectTitle(boSub.getSubjectTitle());
			tempSub.setDuration(boSub.getDuration());
			subList.add(tempSub);
		});
		return subList;
	}
}
