package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
//import jakarta.validation.Valid;
import java.util.List;





@Controller
public class BookController {
	
		
		@Autowired
		private BookService service;
		
		
		@Autowired
		private BookService myBookService;
		
		@GetMapping("/")
		public String home() {
			return "home";
		}
			
			
			@GetMapping("/book_register")
			public String showBookRegisterPage(Model model) {
			    model.addAttribute("book", new Book());
			    return "bookRegister"; 
			}
		
	
		@GetMapping("/available_books")
		public String getAllBooks(Model model) {
			List<Book>books=service.getAllBooks();
			model.addAttribute("books",books);
			return "bookList";
		}
		
		
		
		
		@PostMapping("/book_register")
		public String registerBook(@Validated @ModelAttribute("book") Book book, BindingResult result) {
		    if (result.hasErrors()) {
		        return "bookRegister"; // Redisplay the form on validation errors
		    }
		    service.saveBook(book); // Ensure service logic for saving is implemented
		    return "success";
		}
		
		
		
		
		
		//@PostMapping("/save")
		public String saveBook(@ModelAttribute Book book) {
			service.save(book);
			return "redirect:/available_books";
		}
	
	

	
	
}
	



