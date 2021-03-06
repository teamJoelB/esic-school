package fr.esic;

import java.text.DateFormat;
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
import fr.esic.repository.MailRepository;
import fr.esic.repository.QcmRepository;
import fr.esic.repository.RdvRepository;
import fr.esic.repository.SessionRepository;
import fr.esic.repository.UtilisateurRepository;
import fr.esic.services.MailService;
import fr.esic.entities.Utilisateur;
import fr.esic.entities.enums.Langue;
import fr.esic.entities.enums.NiveauLangue;
import fr.esic.entities.enums.Role;

@SpringBootApplication
public class EsicSchoolBackApplication implements CommandLineRunner {
	@Autowired
	private FormationRepository formationRepo;
	@Autowired
	private UtilisateurRepository userRepo;
	@Autowired
	private MailRepository mailRepo;
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

		Formation f1 = new Formation(null, 5, "TSSR", "Technicien superieur systeme et reseau");
		Formation f2 = new Formation(null, 6, "AR", "Administrateur reseau");
		Formation f3 = new Formation(null, 7, "ESI", "Expert en systemes d'information");
		Formation f4 = new Formation(null, 6, "CEA", "Concepteur developpeur d'application");
		Formation f5 = new Formation(null, 5, "BTSS LAM", "Solutions logicielles et applications métier");
		Formation f6 = new Formation(null, 7, "IA", "Ingenieur affaire");

		formationRepo.save(f1);
		formationRepo.save(f2);
		formationRepo.save(f3);
		formationRepo.save(f4);
		formationRepo.save(f5);
		formationRepo.save(f6);
		
		Session s1 = new Session(null, "Session du 12/02/2022 au 20/06/2022 - IA", f6);
		Session s2 = new Session(null, "Session du 15/02/2022 au 15/06/2022 - AR", f2);
		Session s3 = new Session(null, "Session du 18/09/2022 au 15/06/2023 - TSSR", f1);
		Session s4 = new Session(null, "Session du 18/09/2022 au 18/06/2024 - CEA", f4);
		//Session s5 = new Session(null, "Session du 18/09/2022 au 15/06/2023 - RCM", );
		Session s6 = new Session(null, "Session du 25/09/2022 au 15/06/2023 - AR", f2);
		Session s7 = new Session(null, "Session du 22/09/2022 au 15/05/2023 - CEA", f4);

		sessionRepo.save(s1);
		sessionRepo.save(s2);
		sessionRepo.save(s3);
		sessionRepo.save(s4);
		//sessionRepo.save(s5);
		sessionRepo.save(s6);
		sessionRepo.save(s7);
		

		Utilisateur u1 = new Utilisateur(Role.CANDIDAT, null, "chameau@yahoo.fr", "lama", "Sapin", "Noël", 0, null,
				null, false, null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null,
				null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null,
				null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null,
				false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null,
				false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null);
		Utilisateur u2 = new Utilisateur(Role.CANDIDAT, null, "burtznicolas@yahoo.fr", "banane", "Burtz", "Nicolas", 0,
				null, null, false, null, false, null, null, null, null, 0, null, null, null, null, null, null, null,
				null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null,
				null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null,
				false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null,
				false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null);
		

		Utilisateur u3 = new Utilisateur(null, null, "0", null, "burtznicolas@yahoo.fr", null, 0, null, null, false,
				null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0,
				null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null,
				null, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, false, null,
				null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null);

		Utilisateur u4 = new Utilisateur(Role.CANDIDAT, null, "juliette.pims@gmail.com", "chameau", "Lama", "Sté", 0,
				s1, true);
		Utilisateur u5 = new Utilisateur(Role.CONSEILLER_DE_FORMATION, null, "faux@gmail.com", "sapin", "Con", "Nard",
				2, s2, true);
		
		Utilisateur admin = new Utilisateur(Role.ADMINISTRATEUR, null, "lama@mail.fr", "mdp", "Némar", "Jean", 0, s3,
				false);
		
		DateFormat d = new SimpleDateFormat("yyyy/MM/dd");
		Utilisateur u6 = new Utilisateur(Role.CANDIDAT, null, "coco@yahoo.fr", "lama", "burtz", "nicolas", 0,s1,
		"ing", false, "burtz", false, null,d.parse("1999/01/01") , "Paris", "rue lacourbe", 95, "Paris", "0650605060", "0650605069", "Francaise", "06506050607262", "salarié", "JACK", "tom",
		"pere", "rue lacourbe", 95, "Paris", "0650605635", "0650605066", "jack@gmail.com", false, "Solutec", "Rue Carotte", "non merci", true, "Jack95", d.parse("2020/01/01"), false,"paris3", "Lulu", "terminal",
		"bac", "brevet", "ASSR", 2, "bon", "bon", "francais", "courant", Langue.Arabe, NiveauLangue.A2, Langue.Allemand, NiveauLangue.A1, Langue.Arabe_égyptien, NiveauLangue.A1, Langue.Cantonais, NiveauLangue.A1,
		true, 1, false, "ALI", "rue lecourbe", 75, "Paris", "rue lecourbe", 75, "Paris", false, d.parse("2022/01/01"), "JAI", "Olivier", "Ingénieur", "0645524020", "olivier@gmail.com", "A",
		false, "non", "Avons nous manger?", "Avons nous manger2?", "Avons nous manger3?", "Avons nous manger4?", "Avons nous manger5?", "Avons nous manger6?", "Avons nous manger7?", "Avons nous manger8?", "non", null, null, null, null, null, null,
		null, null, null, null, null, null);
		
		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
		userRepo.save(u4);
		userRepo.save(u5);		
		userRepo.save(u6);		
		userRepo.save(admin);
		
		/*
		 * Mail m1 = new Mail(null,
		 * "Confirmation de compte","hello :)","burtznicolas@yahoo.fr");
		 * mailRepo.save(m1); System.out.println(m1); MailRest mailRest = new
		 * MailRest(); mailRest.mailCreationCompte(u2);
		 */

		Qcm q1 = new Qcm(null, "tentaive 1 de question", "rep 1", "rep2", "rep3", "rep4", 2, "TSSR");
		Qcm q2 = new Qcm(null, "tentaive 2 de question", "rep 1", "rep2", "rep3", "rep4", 2, "TSSR");
		Qcm q3 = new Qcm(null, "tentaive 3 de question", "rep 1", "rep2", "rep3", "rep4", 2, "CEA");
		Qcm q4 = new Qcm(null, "tentaive 4 de question", "rep 1", "rep2", "rep3", "rep4", 2, "TSSR");
		Qcm q5 = new Qcm(null, "tentaive 5 de question", "rep 1", "rep2", "rep3", "rep4", 2, "CEA");
		Qcm q6 = new Qcm(null, "tentaive 6 de question", "rep 1", "rep2", "rep3", "rep4", 2, "AR");
		Qcm q7 = new Qcm(null, "tentaive 7 de question", "rep 1", "rep2", "rep3", "rep4", 2, "AR");
		Qcm q8 = new Qcm(null, "tentaive 8 de question", "rep 1", "rep2", "rep3", "rep4", 2, "AR");
		Qcm q9 = new Qcm(null, "tentaive 69de question", "rep 1", "rep2", "rep3", "rep4", 2, "CEA");
		/*
		 * qcmRepo.save(q1); qcmRepo.save(q2); qcmRepo.save(q3); qcmRepo.save(q4);
		 * qcmRepo.save(q5); qcmRepo.save(q6); qcmRepo.save(q7); qcmRepo.save(q8);
		 * qcmRepo.save(q9);
		 */

		Rdv r1 = new Rdv(null, new Date(), "entretien test 785", u2, u1, "lien@teams",
				"Ceci est un message additionnel.", false);
		rdvRepo.save(r1);

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		

	}
}
