package fr.esic.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.esic.entities.Utilisateur;
import fr.esic.repository.UtilisateurRepository;

@RestController

@CrossOrigin("*")
public class UtilisateurRest {

	@Autowired
	UtilisateurRepository userRepo;
	
	//Afficher tout les utilisateur
	@GetMapping("utilisateur")
	public Iterable<Utilisateur> getAllUtilisateur(){
		return userRepo.findAll();
	}
	
	// Creer un nouvel utilisateur (inscription)
	@PostMapping("utilisateur")
	public Utilisateur createUtilisateur (@RequestBody Utilisateur i) {
		userRepo.save(i);
		return i;
		
	}
	
	// Afficher un utilisateur suivant son id
	@GetMapping("utilisateur/{id}")
	public Optional<Utilisateur> getOneUtilisateur (@PathVariable Long id){	
		return userRepo.findById(id);
	}
	
	// Suprimer un utilisateur suivant son id ???????????????
	@RequestMapping("utilisateur/del/{id}")
	public void deleteUtilisateur(@PathVariable Long id){	
		
		userRepo.deleteById(id);
	}
	
	// Modifier un utilisateur
	@PostMapping("utilisateur/modification")
	public Utilisateur modifUtilisateur (@RequestBody Utilisateur id) {
		userRepo.save(id);
		return id;	
	}

	// Vérifier les login et mdp pour se connecter
	@PostMapping("connexion")
	public Utilisateur connect(@RequestBody Utilisateur p) {
		return userRepo.getByLoginAndPassword(p.getMail(), p.getMdp());
		}
	
	//Afficher tout les candidats
	@GetMapping("candidats")
	public Iterable<Utilisateur> getAllCandidat(){
		return userRepo.findAll();
	}
	
	
	//Affichier tout les respos (fonctionnalités que pour l'admin)
	
	

	
	// Modifier les données des candidats 
	
	
	
	
	
	// indiquer la demande de suppression d'un utilisateur
	
	
	
	

}
