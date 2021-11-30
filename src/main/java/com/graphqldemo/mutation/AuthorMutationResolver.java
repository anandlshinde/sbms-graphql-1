package com.graphqldemo.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqldemo.entity.Author;
import com.graphqldemo.repository.AuthorRepository;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

	
	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorMutationResolver(AuthorRepository repository) {
		this.authorRepository=repository;
	}
	
	
	public Author createAuthor(String name,Integer age) {
		Author author=new Author();
		author.setName(name);
		author.setAge(age);
		
		this.authorRepository.save(author);
		
		return author;
	}
	
	
}
