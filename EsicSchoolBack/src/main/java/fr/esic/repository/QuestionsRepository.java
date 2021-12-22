package fr.esic.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Questions;

public interface QuestionsRepository extends CrudRepository{
	List<Questions> findByNom(String formation);
}
	
