package fr.esic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.esic.entities.Formation;
import fr.esic.repository.FormationRepository;

@RestController

@CrossOrigin("*")
public class FormationRest {
	@Autowired
	private FormationRepository formationRepo;
	
	@GetMapping("formation")
	public  Iterable<Formation> getAllFormation(){
		return formationRepo.findAll();
		}

}
