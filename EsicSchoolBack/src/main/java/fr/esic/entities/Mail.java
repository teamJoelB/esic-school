package fr.esic.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Mail {
	@Id @GeneratedValue
	private Long id;
	private String objet;
	@OneToOne
	private Utilisateur destinataire;
	private String message;
	
}