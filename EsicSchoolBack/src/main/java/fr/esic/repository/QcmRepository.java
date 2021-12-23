package fr.esic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Qcm;

public interface QcmRepository extends CrudRepository<Qcm,Long> {

	@Query(value = "SELECT q FROM Qcm q WHERE q.formation = ?1")
	public Iterable<Qcm> getByFormation(String formation); 

}
