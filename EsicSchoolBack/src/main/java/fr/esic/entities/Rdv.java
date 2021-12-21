package fr.esic.entities;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Rdv {
	@Id @GeneratedValue
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String objet;
	@OneToOne
	private Utilisateur emetteur;
	@OneToOne
	private Utilisateur destinataire;
	private String lien;
	private String message;
	private boolean valider;
}