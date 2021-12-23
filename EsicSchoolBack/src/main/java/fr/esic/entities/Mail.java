package fr.esic.entities;

<<<<<<< HEAD
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
=======
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
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
>>>>>>> branch 'master' of https://github.com/teamJoelB/esic-school.git
}