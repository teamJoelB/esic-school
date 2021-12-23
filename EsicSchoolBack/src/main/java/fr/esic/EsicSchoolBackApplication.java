package fr.esic;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fr.esic.entities.Formation;
import fr.esic.entities.Mail;
import fr.esic.entities.Qcm;
import fr.esic.entities.Rdv;
import fr.esic.repository.FormationRepository;
import fr.esic.repository.MailRepository;
import fr.esic.repository.QcmRepository;
import fr.esic.repository.RdvRepository;
import fr.esic.repository.UtilisateurRepository;
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
<<<<<<< HEAD
	private MailRepository mailRepo;

=======
>>>>>>> branch 'master' of https://github.com/teamJoelB/esic-school.git
	private QcmRepository qcmRepo;
	@Autowired
	private RdvRepository rdvRepo;


	public static void main(String[] args) {
		SpringApplication.run(EsicSchoolBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement projet OK");
		
		
		
		Formation f1 = new Formation(null, 7,"tssr");
		Formation f2 = new Formation(null, 5,"Administrateur_reseau");
		Formation f3 = new Formation(null, 5,"Expert_en_systemes_d_information");
		Formation f4 = new Formation(null, 5,"Concepteur_developpeur_d_application");

		formationRepo.save(f1);
		formationRepo.save(f2);
<<<<<<< HEAD
	Utilisateur u3 = new Utilisateur(null, null, "0" ,null, "burtznicolas@yahoo.fr", null, null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
	userRepo.save(u3);
	System.out.println(u3);
	
=======
		formationRepo.save(f3);
		formationRepo.save(f4);
		/*
>>>>>>> branch 'master' of https://github.com/teamJoelB/esic-school.git
		Utilisateur u1 = new Utilisateur(Role.CANDIDAT, null, "chameau@yahoo.fr", "lama", "Sapin", "Noël", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
		Utilisateur u2 = new Utilisateur(Role.CANDIDAT, null, "burtznicolas@yahoo.fr", "banane", "Burtz", "Nicolas", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/teamJoelB/esic-school.git
		*/
		
		/*
		Utilisateur u3 = new Utilisateur(null, null, "0", null, "burtznicolas@yahoo.fr", null, null, false, null, null,
				null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null,
				false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null,
				null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null,
				false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null,
				null, null);
		userRepo.save(u3);
		System.out.println(u3);
		//Utilisateur u1 = new Utilisateur(Role.CANDIDAT, null, "chameau@yahoo.fr", "lama", "Sapin", "Noël", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
		//Utilisateur u2 = new Utilisateur(Role.CONSEILLER_DE_FORMATION, null, "burtznicolas@yahoo.fr", "banane", "Burtz", "Nicolas", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
		//Utilisateur u4 = new Utilisateur(Role.CANDIDAT, null, "juliette.pims@gmail.com", "chameau", "Lama", "Sté", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);

		//Utilisateur u1 = new Utilisateur(Role.CANDIDAT, null, "chameau@yahoo.fr", "lama", "Sapin", "Noël", null, false,
				null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null,
				null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0,
				null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null,
				0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null,
				null, null, null, null);
		Utilisateur u2 = new Utilisateur(Role.CANDIDAT, null, "burtznicolas@yahoo.fr", "banane", "Burtz", "Nicolas",
				null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0,
				null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null,
				null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0,
				null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null,
				null, null, null, null, null, null);*/
<<<<<<< HEAD
	/*	
		Utilisateur u1 = new Utilisateur(Role.CANDIDAT, null, "juliette.pims@gmail.com", "chameau", "Lama", "Sté", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null);
		Utilisateur u2 = new Utilisateur(Role.CONSEILLER_DE_FORMATION, null, "faux@gmail.com", "sapin", "Con", "Nard", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null);

=======
		
		Utilisateur u1 = new Utilisateur(Role.CANDIDAT, null, "juliette.pims@gmail.com", "chameau", "Lama", "Sté", 0, null);
		Utilisateur u2 = new Utilisateur(Role.CONSEILLER_DE_FORMATION, null, "faux@gmail.com", "sapin", "Con", "Nard",2,null);
>>>>>>> branch 'master' of https://github.com/teamJoelB/esic-school.git
		userRepo.save(u1);
		userRepo.save(u2);
<<<<<<< HEAD
		System.out.println(u2);
		
		Mail m1 = new Mail(null, "Confirmation de compte","hello :)","burtznicolas@yahoo.fr");
		mailRepo.save(m1);
		System.out.println(m1); 
		MailRest mailRest = new MailRest();
		mailRest.mailCreationCompte(u2);
		*/ 
=======
		 
>>>>>>> branch 'master' of https://github.com/teamJoelB/esic-school.git

		Qcm q1 = new Qcm(null,"tentaive 1 de question","rep 1","rep2","rep3","rep4",2,"Administrateur_reseau3");
		Qcm q2 = new Qcm(null,"tentaive 2 de question","rep 1","rep2","rep3","rep4",2,"Administrateur_reseau");
		Qcm q3 = new Qcm(null,"tentaive 3 de question","rep 1","rep2","rep3","rep4",2,"Expert_en_systemes_d_information");
		Qcm q4 = new Qcm(null,"tentaive 4 de question","rep 1","rep2","rep3","rep4",2,"TSSR");
		Qcm q5 = new Qcm(null,"tentaive 5 de question","rep 1","rep2","rep3","rep4",2,"Expert_en_systemes_d_information");
		Qcm q6= new Qcm(null,"tentaive 6 de question","rep 1","rep2","rep3","rep4",2,"Concepteur_developpeur_d_application");
		
		qcmRepo.save(q1);
		qcmRepo.save(q2);
		qcmRepo.save(q3);
		qcmRepo.save(q4);
		qcmRepo.save(q5);
		qcmRepo.save(q6);
		
/*
		Rdv r1 = new Rdv(null, new Date(), "entretien test 785", u2, u1, "lien@teams", "Ceci est un message additionnel.", false);
		rdvRepo.save(r1);
		System.out.println(u2);
*/
	}
}
