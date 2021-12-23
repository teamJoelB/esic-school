
package fr.esic.entities;
 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Adresse {
	@Id @GeneratedValue
	private Long id;
	private String rue;
	private String codePostal;
	private String ville;
	private String pays;
}
