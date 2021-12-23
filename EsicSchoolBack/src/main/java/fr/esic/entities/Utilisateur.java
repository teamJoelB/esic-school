package fr.esic.entities;

import java.io.File;
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
	
	private String nomCv;
	private byte[] cv;
	
	
	

	public Utilisateur(Role role, Long id, String mail, String mdp, String nomUsage, String prenom, String nomNaissance,
			boolean civ, Date dateCandidature, Date dateNaissance, String lieuNaissance, String adresse, int codePostal,
			String ville, String telFixe, String telPortable, String nationalité, Long numSecuSocial,
			String situationActuelle, String nomRepresentant, String prenomRepresentant, String typeRepresentant,
			String adresseRepresentant, int codePostalRepresentant, String villeRepresentant,
			String telFixeRepresentant, String telPortableRepresentant, String emailRepresentant, boolean handicap,
			String nomOrganisme, String coordOrganisme, String besoinParticulier, boolean poleEmploi,
			String identifiantPoleEmploi, Date inscriptionPoleEmploi, boolean missionLocal, String coordMissionLocal,
			String nomConseillerMissionLocal, String derniereClasse, String diplome1, String diplome2, String diplome3,
			double dureeExperience, NiveauLangue niveauFrancais, NiveauLangue niveauAnglais, Langue langue1,
			NiveauLangue niveau1, Langue langue2, NiveauLangue niveau2, Langue langue3, NiveauLangue niveau3,
			Langue langue4, NiveauLangue niveau4, boolean contactEntreprise, int nombreContactEntreprise,
			boolean trouveEntreprise, String nomEntreprise, String adresseSiegeSocial, int codePostalSiegeSocial,
			String villeSiegeSocial, String adresseEntreprise, int codePostalEntreprise, String villeEntreprise,
			boolean contratSigne, Date dateDemarrageContrat, String nomContact, String prenomContact,
			String fonctionContact, String telContact, String mailContact, Permis permis, boolean vehicule,
			String connaissanceEsic, String question1, String question2, String question3, String question4,
			String question5, String question6, String question7, String question8, String commentaire) {
		this.role = role;
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
		this.nomUsage = nomUsage;
		this.prenom = prenom;
		this.nomNaissance = nomNaissance;
		this.civ = civ;
		this.dateCandidature = dateCandidature;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.codePostal = codePostal;
		Ville = ville;
		this.telFixe = telFixe;
		this.telPortable = telPortable;
		this.nationalité = nationalité;
		this.numSecuSocial = numSecuSocial;
		this.situationActuelle = situationActuelle;
		this.nomRepresentant = nomRepresentant;
		this.prenomRepresentant = prenomRepresentant;
		this.typeRepresentant = typeRepresentant;
		this.adresseRepresentant = adresseRepresentant;
		this.codePostalRepresentant = codePostalRepresentant;
		this.villeRepresentant = villeRepresentant;
		this.telFixeRepresentant = telFixeRepresentant;
		this.telPortableRepresentant = telPortableRepresentant;
		this.emailRepresentant = emailRepresentant;
		this.handicap = handicap;
		this.nomOrganisme = nomOrganisme;
		this.coordOrganisme = coordOrganisme;
		this.besoinParticulier = besoinParticulier;
		this.poleEmploi = poleEmploi;
		this.identifiantPoleEmploi = identifiantPoleEmploi;
		this.inscriptionPoleEmploi = inscriptionPoleEmploi;
		this.missionLocal = missionLocal;
		this.coordMissionLocal = coordMissionLocal;
		this.nomConseillerMissionLocal = nomConseillerMissionLocal;
		this.derniereClasse = derniereClasse;
		this.diplome1 = diplome1;
		this.diplome2 = diplome2;
		this.diplome3 = diplome3;
		this.dureeExperience = dureeExperience;
		this.niveauFrancais = niveauFrancais;
		this.niveauAnglais = niveauAnglais;
		this.langue1 = langue1;
		this.niveau1 = niveau1;
		this.langue2 = langue2;
		this.niveau2 = niveau2;
		this.langue3 = langue3;
		this.niveau3 = niveau3;
		this.langue4 = langue4;
		this.niveau4 = niveau4;
		this.contactEntreprise = contactEntreprise;
		this.nombreContactEntreprise = nombreContactEntreprise;
		this.trouveEntreprise = trouveEntreprise;
		this.nomEntreprise = nomEntreprise;
		this.adresseSiegeSocial = adresseSiegeSocial;
		this.codePostalSiegeSocial = codePostalSiegeSocial;
		VilleSiegeSocial = villeSiegeSocial;
		this.adresseEntreprise = adresseEntreprise;
		this.codePostalEntreprise = codePostalEntreprise;
		VilleEntreprise = villeEntreprise;
		this.contratSigne = contratSigne;
		this.dateDemarrageContrat = dateDemarrageContrat;
		this.nomContact = nomContact;
		this.prenomContact = prenomContact;
		this.fonctionContact = fonctionContact;
		this.telContact = telContact;
		this.mailContact = mailContact;
		this.permis = permis;
		this.vehicule = vehicule;
		this.connaissanceEsic = connaissanceEsic;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.question6 = question6;
		this.question7 = question7;
		this.question8 = question8;
		this.commentaire = commentaire;
	}
	
	
	
}
