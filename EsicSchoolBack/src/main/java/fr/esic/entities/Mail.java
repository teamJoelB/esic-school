package fr.esic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Mail {
	@Id @GeneratedValue
	private Long id;
	private String objet;
	private String contenu;
	private String destinataire;
//	private Integer codeVerification;
}