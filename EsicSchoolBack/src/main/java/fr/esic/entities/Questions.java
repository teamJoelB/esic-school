package fr.esic.entities;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Data @NoArgsConstructor
@Entity



public class Questions {
	/*void Constructor(text, choice, answer)
		this.text=text;
		this.choice=choice;
		this.answer=answer;
	
	
	isCorrectAnswer(choice)
		return this.answer===choice;*/
	
	@Id @GeneratedValue
	private Long idquestion;
	private String question;
	@ManyToOne
	private String formation;
	private String bonnereponse;
	
}


		
	


/*public void AllQuestions(Long idquestion, String question, String bonnereponse) {
	this.idquestion=idquestion;
	this.question=question;
	this.bonnereponse=bonnereponse;*/








	

 