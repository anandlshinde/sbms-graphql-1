package com.graphqldemo.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqldemo.entity.Author;
import com.graphqldemo.entity.Tutorial;
import com.graphqldemo.exception.AuthorNotFoundException;
import com.graphqldemo.exception.TutorialNotFoundException;
import com.graphqldemo.repository.AuthorRepository;
import com.graphqldemo.repository.TutorialRepository;

@Component
public class TutorialQueryResolver implements GraphQLQueryResolver {

	private TutorialRepository tutorialRepository;
	private AuthorRepository authorRepository;
	
	@Autowired
	public TutorialQueryResolver(TutorialRepository tutrepository,AuthorRepository authrepository) {
		this.tutorialRepository=tutrepository;
		this.authorRepository=authrepository;
	}
	
	public Iterable<Tutorial> findAllTutorials(){
		return this.tutorialRepository.findAll();
	}
	
	public long countTutorials() {
		return this.tutorialRepository.count();
	}
	
	
	public Author getAuthor(Tutorial tutorial) {
		return this.authorRepository.findById(tutorial.getAuthor().getId()).orElse(null);
	}
	
}
