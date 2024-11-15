package co.edu.ufps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Email;
import co.edu.ufps.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
    
    @Autowired
    EmailService emailService;
    
    @PostMapping("/send")
    public ResponseEntity<?> create(@RequestBody Email email) {
    	emailService.sendSimpleEmail(email);
        return ResponseEntity.ok("OK");
    }
}
