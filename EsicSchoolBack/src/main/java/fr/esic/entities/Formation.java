package fr.esic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Formation {
	@Id @GeneratedValue
	private Long idFormation;
	private int nivcertif; //private String niveau certification;
}