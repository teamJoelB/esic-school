package fr.esic.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import fr.esic.entities.Mail;

public interface MailRepository extends JpaRepository<Mail, Long> {
	
	
	
}


=======
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Mail;

public interface MailRepository extends CrudRepository<Mail, Long>{

}
>>>>>>> branch 'master' of https://github.com/teamJoelB/esic-school.git
