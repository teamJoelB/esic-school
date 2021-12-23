package fr.esic.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import fr.esic.entities.Formation;
import fr.esic.entities.Qcm;
import fr.esic.repository.FormationRepository;

@RestController

@CrossOrigin("*")
public class FormationRest {
	@Autowired
	private FormationRepository formationRepo;
	
	// voir toute les formations
	@GetMapping("formation")
	public  Iterable<Formation> getAllFormation(){
		return formationRepo.findAll();
	}
		
	// creer une formation
	@PostMapping("formation")
	public Formation createFormation(@RequestBody Formation f) {
		return formationRepo.save(f);
	}
	
	//voir une formation
	@GetMapping("formation/{intitule}")
	public Optional<Formation> findByIntitule (@PathVariable String intitule){
		return formationRepo.findByIntitule(intitule);
	}
	
	
	// supprimer une formation
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
	
	//modifier une formation
	
	@PutMapping("formation/{id}")
	public ResponseEntity<Formation> modifFormartion(@PathVariable Long id, @RequestBody Formation formationDetails) throws ResourceNotFoundException {
		Optional<Formation> b = formationRepo.findById(id);
		if(b.isPresent()) {
			Formation f = formationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Formation avec ID : " + id + " non trouvée"));
			f.setIntitule(formationDetails.getIntitule());
			f.setNivCertif(formationDetails.getNivCertif());
			f.setNomComplet(formationDetails.getNomComplet());
			final Formation fUpdated = formationRepo.save(f);
		    return ResponseEntity.ok(fUpdated);
		}else { 
			System.err.println("Formation non trouvé");
			return null;
		}	
		
	}
	
	
	
	
}
