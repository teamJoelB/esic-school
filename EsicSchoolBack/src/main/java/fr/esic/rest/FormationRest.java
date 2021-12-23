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
		
	@PostMapping("formation")
	public Formation createFormation(@RequestBody Formation f) {
		return formationRepo.save(f);
	}
	
	@GetMapping("formation/{intitule}")
	public Optional<Formation> findByIntitule (@PathVariable String intitule){
		return formationRepo.findByIntitule(intitule);
	}
	
	@DeleteMapping("formation/{intitule}")
	public boolean deleteByIntitule(@PathVariable String intitule) {
		Optional<Formation> f = formationRepo.findByIntitule(intitule);
		if(f.isPresent()) {
			formationRepo.deleteById(f.get().getId());
			return true;
		}
		else {
			return false;
		}	
	}
	
	
	
	
	
	
}
