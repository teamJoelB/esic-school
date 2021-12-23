package fr.esic.rest;

<<<<<<< HEAD

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
/*	
	@PostMapping("admin/creation_rdv")
	public Rdv creationRdv(@RequestBody Rdv r) {
		rdvRep.save(r);
		String contenu = "Bonjour " + r.getDestinataire().getPrenom()
				+ " " + r.getDestinataire().getNomUsage() + ",\n"
				+ "\nVous êtes convoqué pour un entretien visio via Teams à la date du "
				+ r.getDate() +".\n"
				+ "Vous trouverez le lien de la réunion ci-dessous : \n"
				+ r.getLien() + "\n"
				+ "Pour valider ou refuser ce RDV, connectez-vous à votre espace personnel.\n"
				+ r.getMessage() + "\n\nCordialement,\n\n"
				+ "\t" + r.getEmetteur().getPrenom() + " " + r.getEmetteur().getNomUsage();
		sendMail(r.getDestinataire().getMail(), r.getObjet(), contenu);
		return r;
	}
	*/
	
	
	
	
=======
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.esic.entities.Rdv;
import fr.esic.repository.MailRepository;

@RestController

@CrossOrigin("*")
public class MailRest {

	@Autowired
	MailRepository mailRepo;
	private String contactEcole = "studyroadsesic@gmail.com";
	private String mdpEcole = "esicschool6!";
	
	public void sendMail(String destinataire, String objet, String contenu) {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(contactEcole, mdpEcole);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(contactEcole));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
			message.setSubject(objet);
			message.setText(contenu);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
>>>>>>> branch 'master' of https://github.com/teamJoelB/esic-school.git
}
