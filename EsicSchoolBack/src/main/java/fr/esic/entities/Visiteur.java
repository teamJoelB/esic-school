package fr.esic.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import fr.esic.entities.enums.Langue;
import fr.esic.entities.enums.NiveauLangue;
import fr.esic.entities.enums.Permis;
import fr.esic.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Visiteur {
	@Id @GeneratedValue
	private Long id;
	private String mail;
	private String mdp;
	private String nomUsage;
	private String prenom;
	private String code;
	private int tentative;
	private boolean ok;
	
}
