package fr.esic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>{
	
	@Query(value = "SELECT p FROM Utilisateur p WHERE p.mail = ?1 AND p.mdp = ?2")
	public Utilisateur getByLoginAndPassword(String mail, String mdp);
}
