package fr.esic.rest;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.esic.entities.Mail;
import fr.esic.entities.Utilisateur;
import fr.esic.repository.MailRepository;
import fr.esic.repository.UtilisateurRepository;

@RestController

@CrossOrigin("*")
public class MailRest {

	@Autowired
	MailRepository mailRepo;
	@Autowired
	UtilisateurRepository userRepo;
}
