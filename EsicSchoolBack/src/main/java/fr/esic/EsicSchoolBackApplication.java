package fr.esic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fr.esic.entities.Formation;
import fr.esic.entities.Mail;
import fr.esic.repository.FormationRepository;
import fr.esic.repository.MailRepository;
import fr.esic.entities.Utilisateur;
import fr.esic.entities.enums.Role;
import fr.esic.repository.UtilisateurRepository;
import fr.esic.rest.MailRest;


@SpringBootApplication
public class EsicSchoolBackApplication implements CommandLineRunner {
	@Autowired
	private FormationRepository formationRepo;
	@Autowired
	private UtilisateurRepository userRepo;
	@Autowired
	private MailRepository mailRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(EsicSchoolBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement projet OK");

		Formation f1=new Formation(null,7);
		Formation f2=new Formation(null,5);
		formationRepo.save(f1);
		formationRepo.save(f2);

		
	Utilisateur u3 = new Utilisateur(null, null, "0" ,null, "burtznicolas@yahoo.fr", null, null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
	userRepo.save(u3);
	System.out.println(u3);
	
		Utilisateur u1 = new Utilisateur(Role.CANDIDAT, null, "chameau@yahoo.fr", "lama", "Sapin", "Noël", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
		Utilisateur u2 = new Utilisateur(Role.CANDIDAT, null, "burtznicolas@yahoo.fr", "banane", "Burtz", "Nicolas", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
		userRepo.save(u1);
		userRepo.save(u2);
		System.out.println(u2);
		
		Mail m1 = new Mail(null, "Confirmation de compte","hello :)","burtznicolas@yahoo.fr");
		mailRepo.save(m1);
		System.out.println(m1); 
		MailRest mailRest = new MailRest();
		mailRest.mailCreationCompte(u2);
	}
}
