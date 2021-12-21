package fr.esic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Rdv;

public interface RdvRepository extends CrudRepository<Rdv, Long>{
	
	@Query(value = "SELECT r FROM Rdv r WHERE destinataire_id = ?1")
	public List<Rdv> getRdvForOne(Long id);
	
	//@Query(value = "DELETE r FROM Rdv r WHERE id = ?1")
	//public void deleteOneRdv(Long id);
}
