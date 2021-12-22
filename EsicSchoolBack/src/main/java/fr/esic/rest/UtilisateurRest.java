package fr.esic.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fr.esic.entities.Utilisateur;
import fr.esic.entities.enums.Role;
import fr.esic.repository.UtilisateurRepository;

@RestController

@CrossOrigin("*")
public class UtilisateurRest {

	@Autowired
	UtilisateurRepository userRepo;
	
	// Vérifier les login et mdp pour se connecter
	@PostMapping("connexion")
	public Utilisateur connect(@RequestBody Utilisateur p) {
		return userRepo.getByLoginAndPassword(p.getMail(), p.getMdp());
	}
	
	// Creer un nouvel utilisateur (inscription)
	@PostMapping("inscription")
	public Utilisateur createUtilisateur (@RequestBody Utilisateur i) {
		i.setRole(Role.CANDIDAT);
		userRepo.save(i);
		return i;
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
	
	// Suprimer un utilisateur suivant son mail (fonctionnalité Administrateur)
	@DeleteMapping("admin/utilisateurs/{mail}")
	public void deleteUtilisateur(@PathVariable String mail){
		userRepo.deleteByMail(mail);
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
	

}
