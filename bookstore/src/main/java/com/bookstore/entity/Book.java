package com.bookstore.entity;


import org.antlr.v4.runtime.misc.NotNull;


import jakarta.persistence.Entity;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="name cannot be blank")
	private String name;
	
	
	private String author;
	
	private Integer price;
	
	
		    
		    // Getters and Setters
		    public String getName() {
		        return name;
		    }

		    public void setName(String name) {
		        this.name = name;
		    }

		    
		    public String getAuthor() {
		        return author;
		    }

		    public void setAuthor(String author) {
		        this.author = author;
		    }
		    

		    public Integer getPrice() {
		        return price;
		    }

		    public void setPrice(Integer price) {
		        this.price = price;
		    }
		    
		    
		    
		    
		    
		    
		}

	
	


