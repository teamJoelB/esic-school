package fr.esic.rest;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.InternetAddress;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import fr.esic.entities.Rdv;
import fr.esic.repository.RdvRepository;
import fr.esic.services.MailService;

@RestController

@CrossOrigin("*")
public class RdvRest {

	@Autowired
	private RdvRepository rdvRep;
	
	// VERSION 1
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
	
	// VERSION 2
	@PostMapping("admin/{prenom}_{nomUsage}/creation_rdv")
	public Rdv creationRdv(@RequestBody Rdv r, @PathVariable String prenom, @PathVariable String nomUsage) {
		rdvRep.save(r);
		String contenu = "Bonjour " + r.getDestinataire().getPrenom()
				+ " " + r.getDestinataire().getNomUsage() + ",\n"
				+ "\nVous êtes convoqué pour un entretien visio via Teams à la date du "
				+ r.getDate() +".\n"
				+ "Vous trouverez le lien de la réunion ci-dessous : \n"
				+ r.getLien() + "\n"
				+ "Pour valider ou refuser ce RDV, connectez-vous à votre espace personnel.\n"
				+ r.getMessage() + "\n\nCordialement,\n\n"
				+ "\t" + prenom + " " + nomUsage;
		MailService.sendMail(r.getDestinataire().getMail(), r.getObjet(), contenu);
		return r;
	}
	
	@GetMapping("candidat/{id}/mes_rdv")
	public Iterable<Rdv> dispAllRdv(@PathVariable Long id) {
		return rdvRep.getRdvForOne(id);
	}
	
	@GetMapping("rdv")
	public Iterable<Rdv> dispAllRdv() {
		return rdvRep.findAll();
	}
	
	/*
	@PutMapping("candidat/{id}/mes_rdv")
	public void valideRdv(@RequestBody Rdv r) throws ResourceNotFoundException {
		Rdv rdv = rdvRep.findById(null).orElseThrow(() -> ResourceNotFoundException("RDV non existant"));	
	}
	@PutMapping("candidat/{id}/mes_rdv")
	public void valideRdv(@RequestBody Rdv r) {
		r.setValider(true);
	}*/
	
	/*
	@DeleteMapping("candidat/{id}/mes_rdv")
	public void deleteOneRdv(@RequestBody Rdv r) {
		rdvRep.delete(r);
	}
	*/
	
	
}
