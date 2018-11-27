package com.lib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lib.beans.Book;
import com.lib.beans.Subject;
import com.lib.service.ApplicationService;

@Controller
public class LibraryController {
	
	public LibraryController() {
		System.out.println("LibraryController Created");
	}
	
	@Autowired
	public ApplicationService applicationService; 

	@RequestMapping("/subform")
	public ModelAndView showform(){
		return new ModelAndView("subform","command",new Subject());
	}
	
	@RequestMapping("/bookForm")
	public ModelAndView bookForm(){
		return new ModelAndView("bookForm","command",new Book());
	}
	
	@RequestMapping("/searchBook")
	public ModelAndView searchBook(){
		return new ModelAndView("viewBook","command",new Book());
	}
	
	@RequestMapping("/searchTitle")
	public ModelAndView searchByTitle(){
		return new ModelAndView("searchTitle","command",new Book());
	}
	
	@RequestMapping("/searchSubject")
	public ModelAndView searchSubject(){
		return new ModelAndView("viewSubject","command",new Subject());
	}
	
	@RequestMapping("/searchDuration")
	public ModelAndView searchDuration(){
		return new ModelAndView("searchDuration","command",new Subject());
	}
	
	@RequestMapping("/deleteBook")
	public ModelAndView deleteBook(){
		return new ModelAndView("deleteBook","command",new Book());
	}
	
	@RequestMapping("/deleteSubject")
	public ModelAndView deleteSubject(){
		return new ModelAndView("deleteSubject","command",new Subject());
	}
	
	@RequestMapping(value="/addSubject",method = RequestMethod.POST)
	public ModelAndView addSubject(@ModelAttribute("sub") Subject sub){
		ModelAndView model = new ModelAndView("subform","command",new Subject());
		model.addObject("message", applicationService.addSubject(sub));
		return model;
	}
	
	@RequestMapping(value="/addBook",method = RequestMethod.POST)
	public ModelAndView addBook(@ModelAttribute("book") Book book){
		ModelAndView model = new ModelAndView("bookForm","command",new Book());
		model.addObject("message", applicationService.addBook(book));
		return model;
	}
	
	@RequestMapping(value="/getSubject",method = RequestMethod.POST)
	public ModelAndView getSubject(@ModelAttribute("subject") Subject subject){
		Subject showSub = applicationService.searchSubject(subject.getSubjectId());
		ModelAndView model = new ModelAndView("viewSubject","showSub",showSub);
		if (null == showSub) {
			model.addObject("message", "Subject is not present in the file");
		}
		model.addObject("command", new Subject());
		return model;
	}
	
	@RequestMapping(value="/getBook",method = RequestMethod.POST)
	public ModelAndView searchBook(@ModelAttribute("book") Book book){
		Book showBook = applicationService.searchBook(book.getBookId());
		ModelAndView model = new ModelAndView("viewBook","showBook",showBook);
		if (null == showBook) {
			model.addObject("message", "Book is not present in the file");
		}
		model.addObject("command", new Book());
		return model;
	}
	
	@RequestMapping(value="/getBookByTitle",method = RequestMethod.POST)
	public ModelAndView getBookByTitle(@ModelAttribute("book") Book book){
		List<Book> bookList = applicationService.searchByTitle(book.getTitle());
		ModelAndView model = new ModelAndView("searchTitle","bookList",bookList);
		if (null == bookList || bookList.size() <= 0) {
			model.addObject("message", "Book by titile "+book.getTitle()+" is not present in the file");
		}
		model.addObject("command", new Book());
		return model;
	}
	//getSubjectByDuration
	@RequestMapping(value="/getSubjectByDuration",method = RequestMethod.POST)
	public ModelAndView getSubjectByDuration(@ModelAttribute("subject") Subject subject){
		List<Subject> subList = applicationService.searchByDuration(subject.getDuration());
		ModelAndView model = new ModelAndView("searchDuration","subList",subList);
		if (null == subList || subList.size() <= 0) {
			model.addObject("message", "Subject is not present for "+ subject.getDuration() +" in the file");
		}
		model.addObject("command", new Subject());
		return model;
	}
	
	@RequestMapping(value="/removeBook",method = RequestMethod.POST)
	public ModelAndView deleteBook(@ModelAttribute("book") Book book){
		ModelAndView model = new ModelAndView("deleteBook","message",applicationService.deleteBook(book.getBookId()));
		model.addObject("command", new Book());
		return model;
	}
	
	@RequestMapping(value="/removeSubject",method = RequestMethod.POST)
	public ModelAndView deleteSubject(@ModelAttribute("subject") Subject subject){
		ModelAndView model = new ModelAndView("deleteSubject","message",applicationService.deleteSubject(subject.getSubjectId()));
		model.addObject("command", new Subject());
		return model;
	}
}
