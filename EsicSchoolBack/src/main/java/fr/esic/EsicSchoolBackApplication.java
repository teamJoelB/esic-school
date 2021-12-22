package fr.esic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.esic.entities.Utilisateur;
import fr.esic.repository.UtilisateurRepository;

@SpringBootApplication
public class EsicSchoolBackApplication implements CommandLineRunner {

	@Autowired
	private UtilisateurRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(EsicSchoolBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement projet OK");
		
	Utilisateur u1 = new Utilisateur(null, null, "0" ,null, "burtznicolas@yahoo.fr", null, null, false, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, 0, null, null, 0, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
	userRepo.save(u1);
	System.out.println(u1);
	}
}
