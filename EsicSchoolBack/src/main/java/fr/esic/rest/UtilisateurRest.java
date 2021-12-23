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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import fr.esic.entities.Formation;
import fr.esic.entities.Mail;
import fr.esic.entities.Utilisateur;
import fr.esic.entities.enums.Role;
import fr.esic.repository.UtilisateurRepository;
import fr.esic.services.MailService;

@RestController

@CrossOrigin("*")
public class UtilisateurRest {

	@Autowired
	UtilisateurRepository userRepo;
	
	// Vérifier les login et mdp pour se connecter
	@PostMapping("connexion")
	public Optional<Utilisateur> connect(@RequestBody Utilisateur p) {
		return userRepo.getByLoginAndPassword(p.getMail(), p.getMdp());
	}
	
	// Creer un nouvel utilisateur (inscription)
	@PostMapping("inscription")
	public Utilisateur createUtilisateur(@RequestBody Utilisateur u) {
		u.setRole(Role.CANDIDAT);
		u.setActif(true);
		userRepo.save(u);
		int tailleCode = 6;
		String code = MailService.getRandomStr(tailleCode);
		String objet = "Inscription Essic School";
		String message = "Bonjour, \n\nVeuillez saisir le code ci-dessous pour finaliser votre inscription à Esic School :\n"
				+ "\t" + code;
		Mail m = new Mail(null, objet, u, message, code);
		MailService.sendMail(u.getMail(), objet, message);
		return u;
	}
	
	// Afficher tous les utilisateurs (fonctionnalité Administrateur)
	@GetMapping("admin/utilisateurs")
	public Iterable<Utilisateur> getAllUtilisateur(){
		return userRepo.findAll();
	}
	
	// Afficher un utilisateur suivant son id (fonctionnalité Administrateur)
	@GetMapping("admin/utilisateurs/{id}")
	public Optional<Utilisateur> getOneUtilisateur (@PathVariable Long id){	
		return userRepo.findById(id);
	}
	
	// Désactiver un utilisateur suivant son id au lieu de la supprimer
	@PutMapping("utilisateur/{id}")
	public ResponseEntity<Utilisateur> desactiveUtilisateur(@PathVariable Long id) throws ResourceNotFoundException {
		Utilisateur u = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utilisateur avec ID : " + id + " non trouvé"));
		u.setActif(false);
		final Utilisateur uUpdated = userRepo.save(u);
	    return ResponseEntity.ok(uUpdated);
	}
	
	//Afficher tous les candidats (visibles par tout le monde sauf les candidats)
	@GetMapping("candidats")
	public Iterable<Utilisateur> getAllCandidat(){
		return userRepo.findAllCandidat();
	}
	
	//Afficher tous les respos (fonctionnalité Administrateur)
	@GetMapping("responsables")
	public Iterable<Utilisateur> getAllResponsable(){
		return userRepo.findAllResponsable();
	}
	
	
	//ajout des pdf de l'utilisateur
	@PutMapping("pdf/{id}")
	public ResponseEntity<Utilisateur> insertPDF(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails) throws ResourceNotFoundException {	
		Utilisateur u = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Formation avec ID : " + id + " non trouvée"));
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
		final Utilisateur uUpdated = userRepo.save(u);
	    return ResponseEntity.ok(uUpdated);
	}
	
	
	
}
