package fr.esic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.esic.entities.Session;
import fr.esic.repository.SessionRepository;

@RestController

@CrossOrigin("*")

public class SessionRest {
	@Autowired
	SessionRepository sessionRepo;
	
	@GetMapping("session")
	public Iterable<Session> getAllSession(){
		return sessionRepo.findAll();
	}
	
	@PostMapping("session")
	public Session createSession (@RequestBody Session s) {
		sessionRepo.save(s);
		return s;
	}
	
}
	
	
	
