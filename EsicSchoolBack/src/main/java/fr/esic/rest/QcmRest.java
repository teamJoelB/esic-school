package fr.esic.rest;

import java.util.ArrayList;
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

import antlr.collections.List;
import fr.esic.entities.Qcm;
import fr.esic.entities.enums.FormationListe;
import fr.esic.repository.QcmRepository;
import lombok.Delegate;

@RestController

@CrossOrigin("*")

public class QcmRest {
	
	@Autowired
	QcmRepository qcmRepo;
	
	// voir toutes les questions
	
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
	public Qcm createQcm (@RequestBody Qcm q) {
		qcmRepo.save(q);
		return q;
	}
	
	//modification d'un QCM
	
	@PutMapping("qcm/{id}")
	public Qcm putQcm(@RequestBody Qcm q, @PathVariable Long id) {
		Qcm qcmin = qcmRepo.findById(id).get();	
		q.setId(id);
		
		return qcmRepo.save(q);
	}
	
	@DeleteMapping("qcm/del/{id}")
	public void deleteQcm(@PathVariable  Long id) {
		qcmRepo.deleteById(id);
	}
	
	
	
	
	
	
}
