package com.cts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookController {
	@Autowired
	BookRepository brepo; 
	String message="";
	
	@RequestMapping(value="/books")
	public ModelAndView getAccounts(ModelAndView model){
		List<Book> bookList = brepo.loadBooks();
		List<Subject> sublist = brepo.loadSubjects();
		System.out.println("In book Controller " + bookList);
		model.addObject("listSubject", sublist);
		model.addObject("listBook", bookList);
		model.addObject("message", message);
		model.setViewName("Books");
		return model;
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public ModelAndView saveSubject(HttpServletRequest request) {
				
		Book book = new Book();
		book.setTitle(request.getParameter("bookTitle"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setVolume(Integer.parseInt(request.getParameter("volume")));
		book.setPublishDate(new java.util.Date());
		
		long subjectId = 0;
		try{
			subjectId = Long.parseLong(request.getParameter("subjectId"));
		}catch(Exception ex){
			
		}
		message = "Book " + request.getParameter("bookTitle") + " successfully added";
		brepo.saveBook(book, subjectId);
		return new ModelAndView("redirect:/books");
	}
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public ModelAndView deleteSubject(HttpServletRequest request) {
	    long bookId = Long.parseLong(request.getParameter("bookId"));
	    brepo.deleteBook(bookId);
	    message = "Book is deleted";
	    return new ModelAndView("redirect:/books");
	}
	
	@RequestMapping(value = "/searchBook", method = RequestMethod.POST)
	public ModelAndView searchSubject(HttpServletRequest request) {	
		
		String booktitle = request.getParameter("searchBox");
		
		List<Book> selectedBookList = brepo.searchBook(booktitle);
		ModelAndView model = new ModelAndView();	
		message = "";
		model.addObject("listBook", selectedBookList);
		model.addObject("message", message);
		model.setViewName("Books");
		return model;
	}
}
