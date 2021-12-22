package fr.esic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.esic.entities.Formation;
import fr.esic.repository.FormationRepository;


@SpringBootApplication
public class EsicSchoolBackApplication implements CommandLineRunner {
	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(EsicSchoolBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement projet OK");
		
		Formation f1=new Formation(null,7);
		Formation f2=new Formation(null,5);
		FormationRepository.save(f1);
		
		
	}

}
