package com.example.demo.Core.Services;

import com.example.demo.Application.InputPort.EmailInputPort;
import com.example.demo.Core.OutputPort.TouristOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailInputPort {

    JavaMailSender emailSender;

    @Autowired
    private TouristOutputPort touristOutputPort;

    public EmailService(JavaMailSender emailSender){
        this.emailSender=emailSender;
    }

   public void sendMessage(String to, String subject, String text){
        String formEmail="timetotravel@gmail.com";
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(formEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        this.emailSender.send(message);
    }
}
