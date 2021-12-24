package fr.esic.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import fr.esic.entities.Formation;
import fr.esic.entities.Mail;
import fr.esic.entities.Qcm;
import fr.esic.entities.Utilisateur;
import fr.esic.entities.Visiteur;
import fr.esic.entities.enums.Role;
import fr.esic.repository.UtilisateurRepository;
import fr.esic.repository.VisiteurRepository;
import fr.esic.services.MailService;

@RestController
@CrossOrigin("*")
public class UtilisateurRest {

	@Autowired
	UtilisateurRepository userRepo;
	@Autowired
	VisiteurRepository visitRepo;

	// Vérifier les login et mdp pour se connecter
	@PostMapping("connexion")
	public Optional<Utilisateur> connect(@RequestBody Utilisateur p) {

		return userRepo.getByLoginAndPassword(p.getMail(), p.getMdp());
	}

	@PostMapping("verifmail/{id}")
	public ResponseEntity<Visiteur> verifUtilisateur(@PathVariable Long id, @RequestBody Visiteur v)
			throws ResourceNotFoundException {
		Visiteur vBd = visitRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Visiteur avec ID : " + id + " non trouvé"));
		int tentative = v.getTentative();
		tentative++;
		if (vBd.getCode().equals(v.getCode()) && tentative < 4) {
			Utilisateur u = new Utilisateur();
			u.setMail(v.getMail());
			u.setMdp(v.getMdp());
			u.setNomUsage(v.getNomUsage());
			u.setPrenom(v.getPrenom());
			u.setRole(Role.CANDIDAT);
			u.setActif(true);
			u.setAvancementInscrit(0);
			userRepo.save(u);
			vBd.setOk(true);
		} else {
			vBd.setTentative(tentative);
		}
		final Visiteur vUpdated = visitRepo.save(vBd);
		return ResponseEntity.ok(vUpdated);
	}

	// Fenêtre pour saisir @mail pour obtenir un mdp temporaire
	@PostMapping("recup_mdp/mail")
	public void saisirMail(@RequestBody Visiteur v) {

	}
	/*
	 * // Envoi d'un mdp temporaire
	 * 
	 * @PostMapping("recup_mdp") public void recuperationMdp(@RequestBody String
	 * mail) { Optional<Utilisateur> user = userRepo.findByMail(mail); int tailleMdp
	 * = 8; String mdp = MailService.getRandomStr(tailleMdp); String objet =
	 * "Récupération mot de passe - Essic School"; String message =
	 * "Bonjour, \n\nVous avez effectué une demande de réinitialisation " +
	 * "de mot de passe pour accéder à Esic School. Vous trouverez ci-dessous votre "
	 * + "mot de passe temporaire :\n\t" + mdp +
	 * "\nSi vous n'êtes pas l'initiateur " +
	 * "de cette demande, veuillez ignorer ce message.\n" +
	 * "\nCordialement\n\n\t Esic School"; u.setMdp(mdp); userRepo.save(u);
	 * MailService.sendMail(u.getMail(), objet, message); return u; }
	 */

	// Afficher tous les utilisateurs (fonctionnalité Administrateur)
	@GetMapping("admin/utilisateurs")
	public Iterable<Utilisateur> getAllUtilisateur() {
		return userRepo.findAll();
	}

	// Afficher un utilisateur suivant son id (fonctionnalité Administrateur)
	@GetMapping("admin/utilisateurs/{id}")
	public Optional<Utilisateur> getOneUtilisateur(@PathVariable Long id) {
		return userRepo.findById(id);
	}

	// Désactiver un utilisateur suivant son id au lieu de la supprimer
	@PutMapping("utilisateur/{id}")
	public ResponseEntity<Utilisateur> desactiveUtilisateur(@PathVariable Long id) throws ResourceNotFoundException {
		Utilisateur u = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur avec ID : " + id + " non trouvé"));
		u.setActif(false);
		u.setAvancementInscrit(-1);
		final Utilisateur uUpdated = userRepo.save(u);
		return ResponseEntity.ok(uUpdated);
	}

	// Afficher tous les candidats (visibles par tout le monde sauf les candidats)
	@GetMapping("candidats")
	public Iterable<Utilisateur> getAllCandidat() {
		return userRepo.findAllCandidat();
	}

	// Afficher tous les respos (fonctionnalité Administrateur)
	@GetMapping("responsables")
	public Iterable<Utilisateur> getAllResponsable() {
		return userRepo.findAllResponsable();
	}

	// ajout des pdf de l'utilisateur
	@PutMapping("inscription/pdf/{id}")
	public ResponseEntity<Utilisateur> ajoutPdf(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails)
			throws ResourceNotFoundException {
		Optional<Utilisateur> b = userRepo.findById(id);
		if (b.isPresent()) {
			Utilisateur u = userRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Formation avec Qcm : " + id + " non trouvée"));
			u.setNomPieceid(utilisateurDetails.getNomPieceid());
			u.setPieceid(utilisateurDetails.getPieceid());
			u.setNomCv(utilisateurDetails.getNomCv());
			u.setCv(utilisateurDetails.getCv());
			u.setNomlm(utilisateurDetails.getNomlm());
			u.setLm(utilisateurDetails.getLm());
			u.setNomddo(utilisateurDetails.getNomddo());
			u.setDdo(utilisateurDetails.getDdo());
			u.setNomrn(utilisateurDetails.getNomrn());
			u.setRn(utilisateurDetails.getRn());
			u.setNomhandi(utilisateurDetails.getNomhandi());
			u.setHandi(utilisateurDetails.getHandi());

			final Utilisateur qUpdated = userRepo.save(u);
			return ResponseEntity.ok(qUpdated);
		} else {
			System.err.println("QCM non trouvé");
			return null;
		}

	}

	// pour test only
	@PostMapping("inscription/information")
	public Utilisateur createUser(@RequestBody Utilisateur u) {
		userRepo.save(u);
		return u;
	}

	// ajout des info de l'utilisateur lors de l'inscription a une formation
	@PutMapping("inscription/information/{id}")
	public ResponseEntity<Utilisateur> modifQcm(@PathVariable Long id, @RequestBody Utilisateur userDetails)
			throws ResourceNotFoundException {
		Optional<Utilisateur> b = userRepo.findById(id);
		if (b.isPresent()) {
			Utilisateur q = userRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Formation avec Qcm : " + id + " non trouvée"));

			q.setCiv(userDetails.getCiv());
			q.setParcours(userDetails.getParcours());
			q.setNomUsage(userDetails.getNomUsage()); //////////////////////////////////////////////
			q.setPrenom(userDetails.getPrenom()); //////////////////////////////////////////////
			q.setNomNaissance(userDetails.getNomNaissance());
			q.setDateNaissance(userDetails.getDateNaissance());
			q.setLieuNaissance(userDetails.getLieuNaissance());
			q.setAdresse(userDetails.getAdresse());
			q.setCodePostal(userDetails.getCodePostal());
			q.setVille(userDetails.getVille());
			q.setTelFixe(userDetails.getTelFixe());
			q.setTelPortable(userDetails.getTelPortable());
			q.setMail(userDetails.getMail()); //////////////////////////////////////////////
			q.setNationalité(userDetails.getNationalité());
			q.setNumSecuSocial(userDetails.getNumSecuSocial());
			q.setNomRepresentant(userDetails.getNomRepresentant());
			q.setPrenomRepresentant(userDetails.getPrenomRepresentant());
			q.setTypeRepresentant(userDetails.getTypeRepresentant());
			q.setAdresseRepresentant(userDetails.getAdresseRepresentant());
			q.setCodePostalRepresentant(userDetails.getCodePostalRepresentant());
			q.setVilleRepresentant(userDetails.getVilleRepresentant());
			q.setTelFixeRepresentant(userDetails.getTelFixeRepresentant());
			q.setTelPortableRepresentant(userDetails.getTelPortableRepresentant());
			q.setEmailRepresentant(userDetails.getEmailRepresentant());
			q.setSituationActuelle(userDetails.getSituationActuelle());
			q.setHandicap(userDetails.getHandicap());
			q.setNomOrganisme(userDetails.getNomOrganisme());
			q.setCoordOrganisme(userDetails.getCoordOrganisme());
			q.setBesoinParticulier(userDetails.getBesoinParticulier());
			q.setPoleEmploi(userDetails.getPoleEmploi());
			q.setIdentifiantPoleEmploi(userDetails.getIdentifiantPoleEmploi());
			q.setInscriptionPoleEmploi(userDetails.getInscriptionPoleEmploi());
			q.setMissionLocal(userDetails.getMissionLocal());
			q.setCoordMissionLocal(userDetails.getCoordMissionLocal());
			q.setNomConseillerMissionLocal(userDetails.getNomConseillerMissionLocal());
			q.setDerniereClasse(userDetails.getDerniereClasse());
			q.setDiplome1(userDetails.getDiplome1());
			q.setDiplome2(userDetails.getDiplome2());
			q.setDiplome3(userDetails.getDiplome3());
			q.setDureeExperience(userDetails.getDureeExperience());

			// langues a mettre
			q.setNiveauFrancais(userDetails.getNiveauFrancais());
			q.setNiveauAnglais(userDetails.getNiveauAnglais());

			q.setContactEntreprise(userDetails.getContactEntreprise());
			q.setNombreContactEntreprise(userDetails.getNombreContactEntreprise());
			q.setTrouveEntreprise(userDetails.getTrouveEntreprise());
			q.setNomEntreprise(userDetails.getNomEntreprise());
			q.setAdresseSiegeSocial(userDetails.getAdresseSiegeSocial());
			q.setCodePostalSiegeSocial(userDetails.getCodePostalSiegeSocial());
			q.setVilleSiegeSocial(userDetails.getVilleSiegeSocial());
			q.setAdresseEntreprise(userDetails.getAdresseEntreprise());
			q.setCodePostalRepresentant(userDetails.getCodePostalEntreprise());
			q.setVilleEntreprise(userDetails.getVilleEntreprise());
			q.setContratSigne(userDetails.getContratSigne());
			q.setDateDemarrageContrat(userDetails.getDateDemarrageContrat());
			q.setNomContact(userDetails.getNomContact());
			q.setPrenomContact(userDetails.getPrenomContact());
			q.setFonctionContact(userDetails.getFonctionContact());
			q.setTelContact(userDetails.getTelContact());
			q.setMailContact(userDetails.getMailContact());
			q.setPermis(userDetails.getPermis());
			q.setVehicule(userDetails.getVehicule());
			q.setConnaissanceEsic(userDetails.getConnaissanceEsic());
			q.setQuestion1(userDetails.getQuestion1());
			q.setQuestion2(userDetails.getQuestion2());
			q.setQuestion3(userDetails.getQuestion3());
			q.setQuestion4(userDetails.getQuestion4());
			q.setQuestion5(userDetails.getQuestion5());
			q.setQuestion6(userDetails.getQuestion6());
			q.setCommentaire(userDetails.getCommentaire());

			final Utilisateur qUpdated = userRepo.save(q);
			return ResponseEntity.ok(qUpdated);
		} else {
			System.err.println("QCM non trouvé");
			return null;
		}
	}
	
	@PutMapping("user/{id}")
	public Utilisateur rajoutIfoUser(@PathVariable Long id, @RequestBody Utilisateur u) {
		u.setId(id);
		return userRepo.save(u);
	}
}
