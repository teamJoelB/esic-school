package fr.esic.repository;

import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Mail;

public interface MailRepository extends CrudRepository<Mail, Long>{

}
