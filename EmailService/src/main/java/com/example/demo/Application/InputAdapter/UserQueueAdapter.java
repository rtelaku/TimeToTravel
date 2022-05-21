package com.example.demo.Application.InputAdapter;

import com.example.demo.Application.Helper.UserRabbitmqHelper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserQueueAdapter {

    @Autowired
    private EmailController emailController;

    @RabbitListener(queues = "eventservice_queue")
    public void test(UserRabbitmqHelper userRabbitmqHelper){
        emailController.sendEmailMessage(userRabbitmqHelper.getEmail());
    }

}
