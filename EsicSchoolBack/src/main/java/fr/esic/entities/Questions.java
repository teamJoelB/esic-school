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
	
	
	@Id @GeneratedValue
	private Long id;
	private String question;
	//@ManyToOne
	//private String formation;
	private String bonneReponse;
	
}

	







	

 