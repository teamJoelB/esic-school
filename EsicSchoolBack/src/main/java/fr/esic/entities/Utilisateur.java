package fr.esic.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import fr.esic.entities.enums.Langue;
import fr.esic.entities.enums.NiveauLangue;
import fr.esic.entities.enums.Parcours;
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
	
	//ATTRIBUTS PROPRES A L AVANCEMENT INSCRIPTION
	private int avancementInscrit;  //-1 compte non actif 0 juste un compte 1 postule 2 piece valide 3 attente test 4 test passé attente result 5 inscrit
	@ManyToOne
	private Formation formation;
	private String parcours;
	
	// ATTRIBUTS PROPRES AU CANDIDAT
	private boolean actif;
	private String nomNaissance;
	private Boolean civ;
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
	
	private Boolean handicap;
	private String nomOrganisme;
	private String coordOrganisme;
	private String besoinParticulier;
	
	private Boolean poleEmploi;
	private String identifiantPoleEmploi;
	@Temporal(TemporalType.DATE)
	private Date inscriptionPoleEmploi;
	private Boolean missionLocal;
	private String coordMissionLocal;
	private String nomConseillerMissionLocal;
	
	private String derniereClasse;
	private String diplome1;
	private String diplome2;
	private String diplome3;
	private double dureeExperience;  // en année genre 1.5 , voir s'il y a pas moyen de faire autrement
	
	private String niveauFrancais;
	private String niveauAnglais;
	
	private String langueautre1;
	private String niveauLangue1;
	 
	
	
	private Langue langue1;
	private NiveauLangue niveau1;
	private Langue langue2;
	private NiveauLangue niveau2;
	private Langue langue3;
	private NiveauLangue niveau3;
	private Langue langue4;
	private NiveauLangue niveau4;
	
	private Boolean contactEntreprise;
	private int nombreContactEntreprise;
	
	private Boolean trouveEntreprise;  // 
	private String nomEntreprise;
	//private Adresse adresseSiegeSocial;
	private String adresseSiegeSocial;
	private int codePostalSiegeSocial;
	private String VilleSiegeSocial;
	//private Adresse adresseEntreprise;  // l'adresse ou l'étudiant va travailler
	private String adresseEntreprise;
	private int codePostalEntreprise;
	private String VilleEntreprise;
	private Boolean contratSigne;
	@Temporal(TemporalType.DATE)
	private Date dateDemarrageContrat;
	private String nomContact;
	private String prenomContact;
	private String fonctionContact;
	private String telContact;
	private String mailContact;
	private String permis;
	private Boolean vehicule;
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
	
	private String nomPieceid;
	@Lob
	private byte[] Pieceid;
	private String nomCv;
	@Lob
	private byte[] cv;
	private String nomlm;
	@Lob
	private byte[] lm;
	private String nomddo;
	@Lob
	private byte[] ddo;
	private String nomrn;
	@Lob
	private byte[] rn;
	private String nomhandi;
	@Lob
	private byte[] handi;
	
	public Utilisateur(Role role, Long id, String mail, String mdp, String nomUsage, String prenom, int avancementInscrit, Formation formation, boolean actif) {
		super();
		this.role = role;
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
		this.nomUsage = nomUsage;
		this.prenom = prenom;
		this.avancementInscrit = avancementInscrit;
		this.formation = formation;
		this.actif = actif;
	}

	public Utilisateur(String nomPieceid, byte[] pieceid, String nomCv, byte[] cv, String nomlm, byte[] lm,
			String nomddo, String nomrn, byte[] rn, String nomhandi, byte[] handi) {
		super();
		this.nomPieceid = nomPieceid;
		Pieceid = pieceid;
		this.nomCv = nomCv;
		this.cv = cv;
		this.nomlm = nomlm;
		this.lm = lm;
		this.nomddo = nomddo;
		this.nomrn = nomrn;
		this.rn = rn;
		this.nomhandi = nomhandi;
		this.handi = handi;
	}
}
