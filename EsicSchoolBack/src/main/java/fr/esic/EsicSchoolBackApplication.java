package fr.esic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import fr.esic.entities.Formation;
import fr.esic.entities.Qcm;
import fr.esic.repository.FormationRepository;
import fr.esic.repository.QcmRepository;
import fr.esic.entities.Utilisateur;
import fr.esic.entities.enums.FormationListe;
import fr.esic.entities.enums.Role;
import fr.esic.repository.UtilisateurRepository;


@SpringBootApplication
public class EsicSchoolBackApplication implements CommandLineRunner {
	@Autowired
	private FormationRepository formationRepo;
	@Autowired
	private UtilisateurRepository userRepo;
	@Autowired
	private QcmRepository qcmRepo;
	
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
		
		
		Utilisateur u1 = new Utilisateur(Role.CANDIDAT, null, "chameau@yahoo.fr", "lama", "Sapin", "Noël", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
		Utilisateur u2 = new Utilisateur(Role.CANDIDAT, null, "burtznicolas@yahoo.fr", "banane", "Burtz", "Nicolas", null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
		userRepo.save(u1);
		userRepo.save(u2);

		Qcm q1 = new Qcm(null,"tentaive 1 de question","rep 1","rep2","rep3","rep4",2,FormationListe.Administrateur_reseau);
		Qcm q2 = new Qcm(null,"tentaive 2 de question","rep 1","rep2","rep3","rep4",2,FormationListe.Administrateur_reseau);
		Qcm q3 = new Qcm(null,"tentaive 3 de question","rep 1","rep2","rep3","rep4",2,FormationListe.Expert_en_systemes_d_information);
		Qcm q4 = new Qcm(null,"tentaive 4 de question","rep 1","rep2","rep3","rep4",2,FormationListe.TSSR);
		Qcm q5 = new Qcm(null,"tentaive 5 de question","rep 1","rep2","rep3","rep4",2,FormationListe.Expert_en_systemes_d_information);
		Qcm q6= new Qcm(null,"tentaive 6 de question","rep 1","rep2","rep3","rep4",2,FormationListe.Concepteur_developpeur_d_application);
		
		qcmRepo.save(q1);
		qcmRepo.save(q2);
		qcmRepo.save(q3);
		qcmRepo.save(q4);
		qcmRepo.save(q5);
		qcmRepo.save(q6);
		
	}
}
