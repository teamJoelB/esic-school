package fr.esic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.esic.entities.Mail;

public interface MailRepository extends JpaRepository<Mail, Long> {
	
	
	
}


