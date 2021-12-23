package fr.esic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import fr.esic.entities.enums.FormationListe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity

public class Qcm {
	
	@Id @GeneratedValue
	private Long id;
	private String txt;
	private String p1;
	private String p2;
	private String p3;
	private String p4;
	private int reponse;
	private FormationListe formation; // a faire en clef etragnere apres les premier tests
	
	
}
