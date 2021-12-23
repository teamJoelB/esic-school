package fr.esic.repository;

import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Session;

public interface SessionRepository extends CrudRepository<Session,Long> {

}
