package fr.esic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>{
	
	@Query(value = "SELECT p FROM Utilisateur p WHERE p.mail = ?1 AND p.mdp = ?2")
	public Optional<Utilisateur> getByLoginAndPassword(String mail, String mdp);
	
	@Query(value = "SELECT p FROM Utilisateur p WHERE p.role = CANDIDAT")
	public Iterable<Utilisateur> findAllCandidat();

	@Query(value = "SELECT p FROM Utilisateur p WHERE p.role = RESPONSABLE_PEDAGOGIQUE")
	public Iterable<Utilisateur> findAllResponsable();

//	@Query(value = "UPDATE Utilisateur p SET p.?1 = p.?2 WHERE p.mail = ?3")
//	public Utilisateur modifyCandidat(String data, String value, String mail);

	@Query(value = "UPDATE Utilisateur u SET u.actif = false")
	public void desactive();
	
	
}
