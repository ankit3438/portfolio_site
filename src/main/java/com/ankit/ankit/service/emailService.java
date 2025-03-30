package com.ankit.ankit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ankit.ankit.dto.ContactRequest;

@Service
public class emailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(ContactRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("ankitjha481@gmail.com"); // Change to your email
        message.setSubject("Someone has contacted you from your website!");
        message.setText("Name: " + request.getName() + "\n" +
                        "Email: " + request.getEmail() + "\n" +
                        "Phone: " + request.getPhone() + "\n\n" +
                        "Message:\n" + request.getMessage());

        mailSender.send(message);
    }
}
