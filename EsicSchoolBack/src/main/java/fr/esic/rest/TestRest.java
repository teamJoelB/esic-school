package fr.esic.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.esic.entities.Formation;
import fr.esic.entities.Questions;
import fr.esic.entities.Test;
import fr.esic.repository.FormationRepository;
import fr.esic.repository.TestRepository;

public class TestRest {
	@Autowired
	private TestRepository testRepo;
	
	@GetMapping("test")
	public  Iterable<Formation> getAllFormation(){
		return testRepo.score;
		}
	
	@PostMapping("test")
	public Test createTest(@Validated @RequestBody Test test) {
		return testRepo.save(test);
	}
	
	public void PassageTest(){
		

	for (String item: List<Questions>) {
		try {
		if (Answer==Questions.bonnereponse){
			int score=score+1;			
		}
		else if(Answer!=Questions.bonnereponse) {
			int score=score;
		}
	}
		
	
}
	}
}
	




