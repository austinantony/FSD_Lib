package com.lib;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lib.beans.Book;
import com.lib.beans.Subject;
import com.lib.repository.BookRepository;
import com.lib.service.ApplicationService;
import com.lib.service.ApplicationServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestApplicationService {

	@TestConfiguration
    static class ApplicationServiceImplTestContextConfiguration {
  
        @Bean
        public ApplicationService applicationService() {
            return new ApplicationServiceImpl();
        }
    }
	
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	BookRepository bookRepo;
	
	@Test
	public void testSearchBookById() {
	    int bookId = 12;
	    Book book = applicationService.searchBook(bookId);
	    assertEquals(12, book.getBookId());
	}
	
	@Test
	public void testSearchSubjectById() {
	    int subId = 3;
	    Subject subject = applicationService.searchSubject(subId);
	    assertEquals(3, subject.getSubjectId());
	}
	
	@Test
	public void testAddBook() {
		Book bookEntity = new Book();
		bookEntity.setBookId(31);
		bookEntity.setTitle("TestBookTitle");
		bookEntity.setPrice(1003.5);
		bookEntity.setVolume(20);
		bookEntity.setPublishedDate(new Date());
		String response = applicationService.addBook(bookEntity);
	    assertEquals("Book added successfully!", response);
	}
	
	@Test
	public void testAddSubject() {
		Subject sub = new Subject();
		sub.setSubjectId(33);
		sub.setSubjectTitle("TestSubject");
		sub.setDuration(420);
	    String response = applicationService.addSubject(sub);
	    assertEquals("Subject added successfully!", response);
	}
	
	@Test
	public void testSearchBookByTitle() {
	    String title = "one";
	    List<Book> bookList = applicationService.searchByTitle(title);
	    assertEquals(title, bookList.get(0).getTitle());
	}
	
	@Test
	public void testSearchSubjectByDuration() {
	    int duration = 10;
	    List<Subject> subject = applicationService.searchByDuration(duration);
	    assertEquals(duration, subject.get(0).getDuration());
	}
}
