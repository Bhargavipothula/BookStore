package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;
    
   @Autowired
    private MyBookListService myBookService;

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
    public ModelAndView getAllBooks() {
        List<Book> list = service.getAllBooks();
        ModelAndView m = new ModelAndView("bookList");
        m.addObject("bookList", list);
        return m;
    }


    @PostMapping("/book_register")
    public String registerBook(@Validated @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "bookRegister";
        }
        service.saveBook(book);
        return "success";
    }
    @GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
    
    @RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		service.saveMyBooks(mb);
		return "redirect:/my_books";
	}
    
    
    
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id")int id,Model model) {
    	Book b=service.getBookById(id);u
    	model.addAttribute("book",b);
    	return "bookEdit";
    }
    
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
    	service.deleteById(id);
    	return "redirect:/available_books";
    }
    

}