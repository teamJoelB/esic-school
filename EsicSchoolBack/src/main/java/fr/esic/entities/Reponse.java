package fr.esic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Reponse {
	@Id @GeneratedValue
	private Long id;
	private String intitule; //private String intitule;
	//@OneToOne
	//private Questions idquestion;
	private boolean type;
	
}