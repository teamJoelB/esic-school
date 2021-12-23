package fr.esic.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.esic.entities.Utilisateur;
import fr.esic.entities.Visiteur;
import fr.esic.entities.enums.Role;
import fr.esic.repository.VisiteurRepository;
import fr.esic.services.MailService;

@RestController

@CrossOrigin("*")
public class VisiteurRest {

	@Autowired
	VisiteurRepository visitRepo;
	
	// Creer un visiteur au moment de l'inscription
	@PostMapping("inscription")
	public Visiteur createVisiteur(@RequestBody Visiteur v) {
		int tailleCode = 6;
		String code = MailService.getRandomStr(tailleCode);
		String objet = "Inscription Essic School";
		String message = "Bonjour, \n\nVeuillez saisir le code ci-dessous pour finaliser votre inscription à Esic School :\n"
				+ "\t" + code;
		v.setCode(code);
		v.setOk(false);
		visitRepo.save(v);
		MailService.sendMail(v.getMail(), objet, message);
		return v;
	}
	
}
