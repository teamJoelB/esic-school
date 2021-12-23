package fr.esic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Utilisateur;
import fr.esic.entities.Visiteur;

public interface VisiteurRepository extends CrudRepository<Visiteur, Long>{
}
