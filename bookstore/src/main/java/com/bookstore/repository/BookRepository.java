package com.bookstore.repository;


import org.springframework.stereotype.Repository;



import com.bookstore.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
	

}