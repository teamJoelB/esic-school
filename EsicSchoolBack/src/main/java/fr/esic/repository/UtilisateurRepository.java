package fr.esic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>{
	
	@Query(value = "SELECT p FROM Utilisateur p WHERE p.mail = ?1 AND p.mdp = ?2")
	public Utilisateur getByLoginAndPassword(String mail, String mdp);
	
	@Query(value = "SELECT p FROM Utilisateur p WHERE p.role = CANDIDAT")
	public Iterable<Utilisateur> findAllCandidat();

	@Query(value = "SELECT p FROM Utilisateur p WHERE p.role = RESPONSABLE_PEDAGOGIQUE")
	public Iterable<Utilisateur> findAllResponsable();

//	@Query(value = "UPDATE Utilisateur p SET p.?1 = p.?2 WHERE p.mail = ?3")
//	public Utilisateur modifyCandidat(String data, String value, String mail);

	@Query(value = "DELETE FROM Utilisateur p WHERE p.mail= ?1")
	public void deleteByMail(String mail);
	
	
}
