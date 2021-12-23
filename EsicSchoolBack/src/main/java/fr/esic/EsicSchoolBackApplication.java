package fr.esic;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.esic.entities.Formation;

import fr.esic.entities.Qcm;

import fr.esic.entities.Rdv;
import fr.esic.entities.Session;
import fr.esic.repository.FormationRepository;

import fr.esic.repository.QcmRepository;

import fr.esic.repository.RdvRepository;
import fr.esic.repository.SessionRepository;
import fr.esic.repository.UtilisateurRepository;
import fr.esic.rest.MailRest;
import fr.esic.services.MailService;
import fr.esic.entities.Utilisateur;
import fr.esic.entities.enums.Role;

@SpringBootApplication
public class EsicSchoolBackApplication implements CommandLineRunner {
	@Autowired
	private FormationRepository formationRepo;
	@Autowired
	private UtilisateurRepository userRepo;
	@Autowired
	private QcmRepository qcmRepo;
	@Autowired
	private RdvRepository rdvRepo;
	@Autowired
	private SessionRepository sessionRepo;

	public static void main(String[] args) {
		SpringApplication.run(EsicSchoolBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement projet OK");
		
		Formation f1 = new Formation(null, 5,"TSSR","Technicien superieur systeme et reseau");
		Formation f2 = new Formation(null, 6,"AR","Administrateur reseau");
		Formation f3 = new Formation(null, 7,"ESI","Expert en systemes d'information");
		Formation f4 = new Formation(null, 6,"CEA","Concepteur developpeur d'application");
		Formation f5 = new Formation(null, 5,"BTSS LAM","Solutions logicielles et applications métier");
		Formation f6 = new Formation(null, 7,"IA","Ingenieur affaire");
		
		
		formationRepo.save(f1);
		formationRepo.save(f2);
		formationRepo.save(f3);
		formationRepo.save(f4);
		formationRepo.save(f5);
		formationRepo.save(f6);
		
		//Utilisateur u1 = new Utilisateur(Role.CANDIDAT, null, "juliette.pims@gmail.com", "chameau", "Lama", "Sté", 0, null, true);
		Utilisateur u1 = new Utilisateur(Role.CANDIDAT, null, "juliette.pims@gmail.com", "chameau", "Lama", "Sté", 0, null, true);
		Utilisateur u2 = new Utilisateur(Role.CONSEILLER_DE_FORMATION, null, "faux@gmail.com", "sapin", "Con", "Nard",2, null, true);
		userRepo.save(u1);
		userRepo.save(u2);
		 

		Qcm q1 = new Qcm(null,"tentaive 1 de question","rep 1","rep2","rep3","rep4",2,"TSSR");
		Qcm q2 = new Qcm(null,"tentaive 2 de question","rep 1","rep2","rep3","rep4",2,"TSSR");
		Qcm q3 = new Qcm(null,"tentaive 3 de question","rep 1","rep2","rep3","rep4",2,"CEA");
		Qcm q4 = new Qcm(null,"tentaive 4 de question","rep 1","rep2","rep3","rep4",2,"TSSR");
		Qcm q5 = new Qcm(null,"tentaive 5 de question","rep 1","rep2","rep3","rep4",2,"CEA");
		Qcm q6 = new Qcm(null,"tentaive 6 de question","rep 1","rep2","rep3","rep4",2,"AR");
		Qcm q7 = new Qcm(null,"tentaive 7 de question","rep 1","rep2","rep3","rep4",2,"AR");
		Qcm q8 = new Qcm(null,"tentaive 8 de question","rep 1","rep2","rep3","rep4",2,"AR");
		Qcm q9 = new Qcm(null,"tentaive 69de question","rep 1","rep2","rep3","rep4",2,"CEA");
		
		qcmRepo.save(q1);
		qcmRepo.save(q2);
		qcmRepo.save(q3);
		qcmRepo.save(q4);
		qcmRepo.save(q5);
		qcmRepo.save(q6);
		qcmRepo.save(q7);
		qcmRepo.save(q8);
		qcmRepo.save(q9);
		
		Rdv r1 = new Rdv(null, new Date(), "entretien test 785", u2, u1, "lien@teams", "Ceci est un message additionnel.", false);
		rdvRepo.save(r1);
		System.out.println(u2);
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		
		Session s1 = new Session(null,"Session du 12/02/2022 au 20/06/2022 - IA");
		Session s2 = new Session(null,"Session du 15/02/2022 au 15/06/2022 - AR");
		Session s3 = new Session(null,"Session du 18/09/2022 au 15/06/2023 - TSSR");
		Session s4 = new Session(null,"Session du 18/09/2022 au 18/06/2024 - CEA");
		Session s5 = new Session(null,"Session du 18/09/2022 au 15/06/2023 - RCM");
		Session s6 = new Session(null,"Session du 25/09/2022 au 15/06/2023 - AR");
		Session s7 = new Session(null,"Session du 22/09/2022 au 15/05/2023 - CEA");
		Session s8 = new Session(null,"___________________________________________________");
				
		sessionRepo.save(s1);
		sessionRepo.save(s2);
		sessionRepo.save(s3);
		sessionRepo.save(s4);
		sessionRepo.save(s5);
		sessionRepo.save(s6);
		sessionRepo.save(s7);
		sessionRepo.save(s8);
		
	}
}
