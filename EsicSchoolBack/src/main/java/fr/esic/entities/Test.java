package fr.esic.entities;

import java.sql.Date;

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
public class Test {
	@Id @GeneratedValue
	private Long id;
	private int score;
	//private Date temps;	

}
