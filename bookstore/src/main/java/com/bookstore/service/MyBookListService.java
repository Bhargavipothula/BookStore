package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.repository.MyBookRepository;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookRepository mybook;
	
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}

	public List<MyBookList> getAllMyBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}