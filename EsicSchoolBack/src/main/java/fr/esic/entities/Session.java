package fr.esic.entities;

import java.net.Authenticator;
import java.sql.Date;
import java.util.Properties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity

public class Session {
	@Id @GeneratedValue
	private Long id;
	private String session;
	@ManyToOne
	private Formation formation;
	public static Session getInstance(Properties props, Authenticator authenticator) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
