package fr.esic.repository;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Formation;

public interface FormationRepository extends CrudRepository<Formation, Long> {

}
