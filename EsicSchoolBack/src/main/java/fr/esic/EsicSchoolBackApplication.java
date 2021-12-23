package fr.esic;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.esic.entities.Formation;

import fr.esic.entities.Qcm;

import fr.esic.entities.Rdv;

import fr.esic.repository.FormationRepository;

import fr.esic.repository.QcmRepository;

import fr.esic.repository.RdvRepository;
import fr.esic.repository.UtilisateurRepository;

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
	

	private RdvRepository rdvRepo;


	public static void main(String[] args) {
		SpringApplication.run(EsicSchoolBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
