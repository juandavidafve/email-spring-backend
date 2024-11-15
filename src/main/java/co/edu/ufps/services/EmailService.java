package co.edu.ufps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Email;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getDestination());
        message.setSubject(email.getSubject());
        message.setText(email.getMessage());
        
        if (email.getCc() != null && email.getCc().length() > 0) {
        	 String[] ccArray = email.getCc().split(",\\s*");
        	 message.setCc(ccArray);
        }

        mailSender.send(message);
    }
}
