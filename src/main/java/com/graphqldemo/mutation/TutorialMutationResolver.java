package com.graphqldemo.mutation;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqldemo.entity.Author;
import com.graphqldemo.entity.Tutorial;
import com.graphqldemo.exception.TutorialNotFoundException;
import com.graphqldemo.repository.TutorialRepository;


@Component
public class TutorialMutationResolver implements GraphQLMutationResolver {

	private Logger logger=LoggerFactory.getLogger(TutorialMutationResolver.class);
	private TutorialRepository tutorialRepository;
	
	@Autowired
	public TutorialMutationResolver(TutorialRepository repository) {
		this.tutorialRepository=repository;
	}
	
	public Tutorial createTutorial(String title,String description,Long authorId) {
		Tutorial tutorial=new Tutorial();
		
		tutorial.setTitle(title);
		tutorial.setDescription(description);
		tutorial.setAuthor(new Author(authorId));
		
		this.tutorialRepository.save(tutorial);
		
		return tutorial;
	}
	
	public boolean deleteTutorial(Long tutorialId) {
		this.tutorialRepository.deleteById(tutorialId);
		return true;
	}
	
	public Tutorial updateTutorial(Long tutorialId,String title,String description) throws TutorialNotFoundException {
		Optional<Tutorial> opTutorial = this.tutorialRepository.findById(tutorialId);
		logger.info("opTutorial is present :: "+opTutorial.isPresent());
		if(opTutorial.isPresent()) {
			
			Tutorial tutorial = opTutorial.get();
			
			if(null!=title) {
				tutorial.setTitle(title);
			}
			if(null!=description) {
				tutorial.setDescription(description);
			}
			
			this.tutorialRepository.save(tutorial);
			return tutorial;
		}else {
		
		throw new TutorialNotFoundException("Tutorial not found for update");
		}
	}
}
