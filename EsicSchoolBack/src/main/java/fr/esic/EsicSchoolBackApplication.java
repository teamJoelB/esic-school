package fr.esic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsicSchoolBackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EsicSchoolBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement projet OK");
		
	}

}
