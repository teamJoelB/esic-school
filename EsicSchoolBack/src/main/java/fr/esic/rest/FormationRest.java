package fr.esic.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@DeleteMapping("formation")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long idformation)
	  throws ResourceNotFoundException {
	   /* Formation formation = formationRepo.findById(idformation)
	      .orElseThrow(() -> new ResourceNotFoundException("Aucune formation trouvée pour l'id :: " + idformation));*/

	    //formationRepo.delete(formation);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	}
	

}
