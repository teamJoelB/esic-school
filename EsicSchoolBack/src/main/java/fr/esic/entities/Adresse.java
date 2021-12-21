package fr.esic.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Adresse {
	private Long id;
	private String rue;
	private String codePostal;
	private String ville;
	private String pays;
}
