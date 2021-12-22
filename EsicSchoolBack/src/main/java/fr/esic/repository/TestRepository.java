package fr.esic.repository;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Test;

public interface TestRepository extends CrudRepository<Test, Long>{

}
