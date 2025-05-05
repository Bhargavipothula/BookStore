package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public void saveBook(Book book) {
        repo.save(book);
    }
    public List<Book> getAllBook(){
    	return repo.findAll();
    }
    public Book getBookById(int id) {
    	return repo.findById(id).get();
    }

	public void saveMyBooks(MyBookList mb) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
}