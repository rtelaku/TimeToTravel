package com.example.demo.Application.InputAdapter;

import com.example.demo.Application.InputPort.EmailInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    //Asinkron

    @Autowired
    private EmailInputPort emailInputPort;

    public EmailController(EmailInputPort emailInputPort){
        this.emailInputPort=emailInputPort;
    }

    @PostMapping("/message/{email}")
    public String sendEmailMessage(@PathVariable("email") String email){
        this.emailInputPort.sendMessage(email, "Confirmation", "With this email we are confirming your participation for event.");
          return "Message is sent";
    }
}
