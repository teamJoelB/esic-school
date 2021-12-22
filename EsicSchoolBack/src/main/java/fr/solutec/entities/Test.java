package fr.solutec.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity

public class Test {
	@Id @GeneratedValue
	private Long idTest; //clé primaire de la table
	@CreationTimestamp
	private Date dateDebut; //attribut pour connaitre date et heure du début du test
	private int score; //attribut pour connaitre le score du test
	
}
