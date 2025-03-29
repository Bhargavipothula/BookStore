package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;



import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;


@Service
public class BookService {
	
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
		
	}
	public List<Book> getAllBooks(){
		return bRepo.findAll();
	}
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		
	}
	

}
