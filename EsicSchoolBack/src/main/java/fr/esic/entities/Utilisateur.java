package fr.esic.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import fr.esic.entities.enums.Langue;
import fr.esic.entities.enums.NiveauLangue;
import fr.esic.entities.enums.Permis;
import fr.esic.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Utilisateur {
	// ATTRIBUTS COMMUNS A TOUS
	private Role role;
	@Id @GeneratedValue
	private Long id;
	@Column(unique=true)
	private String mail;
	private String mdp;
	private String nomUsage;
	private String prenom;
	
	// ATTRIBUTS PROPRES AU CANDIDAT
	
	private String nomNaissance;
	private boolean civ;
	@CreationTimestamp
	private Date dateCandidature;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String lieuNaissance;
	//private Adresse adresse;
	private String adresse;
	private int codePostal;
	private String Ville;
	private String telFixe;
	private String telPortable;
	private String nationalité;
	
	private Long numSecuSocial;
	private String situationActuelle;
		
	private String nomRepresentant;
	private String prenomRepresentant;
	// creer enum (père, mère, tuteur, autres)
	private String typeRepresentant;
	//private Adresse adresseRepresentant;
	private String adresseRepresentant;
	private int codePostalRepresentant;
	private String villeRepresentant;
	private String telFixeRepresentant;
	private String telPortableRepresentant;
	private String emailRepresentant;
	
	private boolean handicap;
	private String nomOrganisme;
	private String coordOrganisme;
	private String besoinParticulier;
	
	private boolean poleEmploi;
	private String identifiantPoleEmploi;
	@Temporal(TemporalType.DATE)
	private Date inscriptionPoleEmploi;
	private boolean missionLocal;
	private String coordMissionLocal;
	private String nomConseillerMissionLocal;
	
	private String derniereClasse;
	private String diplome1;
	private String diplome2;
	private String diplome3;
	private double dureeExperience;  // en année genre 1.5 , voir s'il y a pas moyen de faire autrement
	
	private NiveauLangue  niveauFrancais;
	private NiveauLangue  niveauAnglais;
	
	private Langue langue1;
	private NiveauLangue niveau1;
	private Langue langue2;
	private NiveauLangue niveau2;
	private Langue langue3;
	private NiveauLangue niveau3;
	private Langue langue4;
	private NiveauLangue niveau4;
	
	private boolean contactEntreprise;
	private int nombreContactEntreprise;
	
	private boolean trouveEntreprise;  // 
	private String nomEntreprise;
	//private Adresse adresseSiegeSocial;
	private String adresseSiegeSocial;
	private int codePostalSiegeSocial;
	private String VilleSiegeSocial;
	//private Adresse adresseEntreprise;  // l'adresse ou l'étudiant va travailler
	private String adresseEntreprise;
	private int codePostalEntreprise;
	private String VilleEntreprise;
	private boolean contratSigne;
	@Temporal(TemporalType.DATE)
	private Date dateDemarrageContrat;
	private String nomContact;
	private String prenomContact;
	private String fonctionContact;
	private String telContact;
	private String mailContact;
	private Permis permis;
	private boolean vehicule;
	private String connaissanceEsic;
	
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	private String question5;
	private String question6;
	private String question7;
	private String question8;
	
	private String commentaire;
}
