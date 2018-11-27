package com.lib;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lib.BO.Book;
import com.lib.BO.Subject;
import com.lib.repository.BookRepository;
import com.lib.repository.SubjectRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LibRepoTest {

	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	SubjectRepository subRepo;
	
	@Test
    public void testFindBookById() {
		
		Book bookEntity = new Book();
		bookEntity.setBookId(31);
		bookEntity.setTitle("TestBookTitle");
		bookEntity.setPrice(1003.5);
		bookEntity.setVolume(20);
		bookEntity.setPublishedDate(new Date());
		bookRepo.save(bookEntity);
		
		Book book = bookRepo.findById(31).get();
        assertEquals(31, book.getBookId());
    }
	
	@Test
	public void testFindBookByTitle() {
		
		Book bookEntity = new Book();
		bookEntity.setBookId(31);
		bookEntity.setTitle("TestBookTitle");
		bookEntity.setPrice(1003.5);
		bookEntity.setVolume(20);
		bookEntity.setPublishedDate(new Date());
		bookRepo.save(bookEntity);
		
		List<Book> bookList = bookRepo.find("TestBookTitle");
		assertEquals("TestBookTitle", bookList.get(0).getTitle());
	}
	
	@Test
	public void testDeleteBook() {
		Book bookEntity = new Book();
		bookEntity.setBookId(31);
		bookRepo.delete(bookEntity);
		
		Optional<Book> optBook = bookRepo.findById(31);
        assertEquals(false, optBook.isPresent());
	}
	
	@Test
    public void testFindSubjectById() {
		
		Subject sub = new Subject();
		sub.setSubjectId(33);
		sub.setSubjectTitle("TestSubject");
		sub.setDuration(420);
		subRepo.save(sub);
		
		Subject subject = subRepo.findById(33).get();
        assertEquals(33, subject.getSubjectId());
    }
	
	@Test
	public void testFindSubjectByDuration() {
		
		Subject sub = new Subject();
		sub.setSubjectId(33);
		sub.setSubjectTitle("TestSubject");
		sub.setDuration(10);
		subRepo.save(sub);
		
		List<Subject> subList = subRepo.find(10);
		assertEquals(10, subList.get(0).getDuration());
	}
	
	@Test
	public void testDeleteSubject() {
		Subject subEntity = new Subject();
		subEntity.setSubjectId(33);
		subRepo.delete(subEntity);
		
		Optional<Subject> optSub = subRepo.findById(33);
        assertEquals(false, optSub.isPresent());
	}
}
