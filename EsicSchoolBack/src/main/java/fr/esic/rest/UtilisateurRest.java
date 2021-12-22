package fr.esic.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping("utilisateur")
	public Iterable<Utilisateur> getAllUtilisateur(){
		
		return userRepo.findAll();
	}
	
	@PostMapping("utilisateur")
	public Utilisateur createUtilisateur (@RequestBody Utilisateur i) {
		userRepo.save(i);
		return i;		
	}
	
	@GetMapping("utilisateur/{id}")
	public Optional<Utilisateur> getOneUtilisateur (@PathVariable Long id){	
		return userRepo.findById(id);
	}
	
	@RequestMapping("utilisateur/del/{id}")
	public void deleteUtilisateur(@PathVariable Long id){	
		
		userRepo.deleteById(id);
	}
	
	@PostMapping("utilisateur/modification")
	public Utilisateur modifUtilisateur (@RequestBody Utilisateur id) {
		userRepo.save(id);
		return id;
		
	}

}
