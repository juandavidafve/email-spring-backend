package co.edu.ufps.entities;

import lombok.Data;

@Data
public class Email {
	private String destination;
	private String subject;
	private String cc;
	private String message;
}
