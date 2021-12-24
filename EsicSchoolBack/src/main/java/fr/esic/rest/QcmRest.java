package fr.esic.rest;

import java.util.ArrayList;
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

import antlr.collections.List;
import fr.esic.entities.Formation;
import fr.esic.entities.Qcm;
import fr.esic.repository.QcmRepository;
import lombok.Delegate;

@RestController

@CrossOrigin("*")

public class QcmRest {
	
	@Autowired
	QcmRepository qcmRepo;
	
	// Voir toutes les questions
	@GetMapping("qcm")
	public Iterable<Qcm> getAllQcm(){
		return qcmRepo.findAll();
	}

	
	// Voir toutes les questions d'une formation
	@GetMapping("qcm/{formation}")
	public Iterable<Qcm> findByFormation(@PathVariable String formation){
		return qcmRepo.getByFormation(formation);
	}
	
	
	// creation d'un QCM
	@PostMapping("qcm")
	public Qcm createQcm(@RequestBody Qcm q) {
		qcmRepo.save(q);
		return q;
	}
	
	//Modification d'un QCM
	@PutMapping("qcm/{id}")
	public ResponseEntity<Qcm> modifQcm(@PathVariable Long id, @RequestBody Qcm qcmDetails) throws ResourceNotFoundException {
		Optional<Qcm> b = qcmRepo.findById(id);
		if(b.isPresent()) {
			Qcm q = qcmRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Formation avec Qcm : " + id + " non trouvée"));
			q.setFormation(qcmDetails.getFormation());
			q.setP1(qcmDetails.getP1());
			q.setP2(qcmDetails.getP2());
			q.setP3(qcmDetails.getP3());
			q.setP4(qcmDetails.getP4());
			q.setTxt(qcmDetails.getTxt());
			q.setReponse(qcmDetails.getReponse());
			final Qcm qUpdated = qcmRepo.save(q);
		    return ResponseEntity.ok(qUpdated);
		}else {
			System.err.println("QCM non trouvé");
			return null;
		}	
		
	}	
	
	@DeleteMapping("qcm/del/{id}")
	public boolean deleteQcm(@PathVariable  Long id) {
		Optional<Qcm> q = qcmRepo.findById(id);
		if(q.isPresent()) {
			qcmRepo.deleteById(id); 
			return true;
		}else {
			System.err.println("QCM non trouvé");
			return false;
		}	
	}
	
	
	
	
	
	
}
