package fr.esic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Mail {
	@Id @GeneratedValue
	private Long id;
	private String objet;
	@ManyToOne
	private Utilisateur destinataire;
	private String message;
}