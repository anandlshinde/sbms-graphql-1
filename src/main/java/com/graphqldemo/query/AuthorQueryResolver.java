package com.graphqldemo.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqldemo.entity.Author;
import com.graphqldemo.repository.AuthorRepository;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {

	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorQueryResolver(AuthorRepository repository) {
		this.authorRepository=repository;
	}
	
	
	public Iterable<Author> findAllAuthors(){
		return this.authorRepository.findAll();
	}
	
	public long countAuthors() {
		return this.authorRepository.count();
	}
	
	public Author findByName(String authName) {
		return this.authorRepository.findByName(authName);
	}
}
