package fr.esic.repository;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Formation;
import fr.esic.entities.Test;

public interface TestRepository {

	Iterable<Formation> score = null;

	Iterable<Formation> findAll();

	Test save(Test test);

}
