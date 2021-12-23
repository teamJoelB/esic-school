package fr.esic.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Formation;

public interface FormationRepository extends CrudRepository<Formation, Long> {

	public Optional<Formation> findByIntitule(String intitule);

	//@Query(value = "DELETE FROM Formation f  WHERE f.intitule = ?1")
	//public void deleteByIntitule(String intitule);

}
