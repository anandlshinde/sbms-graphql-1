package com.graphqldemo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphqldemo.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Serializable> {

	public Author findByName(String authName);
	
}
