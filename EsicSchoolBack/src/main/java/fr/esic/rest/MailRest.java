package fr.esic.rest;

import java.util.Properties;
<<<<<<< HEAD
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
=======

>>>>>>> branch 'master' of https://github.com/teamJoelB/esic-school.git
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

/*
import java.util.Properties;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.esic.entities.Mail;
import fr.esic.entities.Utilisateur;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@RestController
@CrossOrigin("*")
public class MailRest {
	
	
	public void sendMail(String destinataire, String objet, String contenu) {
		final String expediteur = "staff.sport2go@gmail.com";
		final String password = "sport2go_2019";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				  new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(expediteur, password);
					}
				  });
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(expediteur));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
			message.setSubject(objet);
			message.setText(contenu);
			Transport.send(message);
			System.out.println("Mail envoyé");
		
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	@RequestMapping("/mailcreationcompte")
	public Mail mailCreationCompte(@RequestBody Utilisateur u){
		Integer codeVerification= 11;
		String destinataire = u.getMail();
		String objet = "Vérification de création du compte";
		String Newligne=System.getProperty("line.separator");
		String contenu = "Bonjour " + u.getPrenom() + " " + u.getNomUsage() + "," 
		+ Newligne + Newligne + "Bienvenue ! "
		+ Newligne + "Ton code de vérification est" + "" + codeVerification +  ""
		+ Newligne + Newligne + "A bientôt !" ;
		Mail m2 = new Mail(null, objet, contenu, destinataire);
		sendMail(destinataire, objet, contenu);
		return m2;
	}
	
 */
