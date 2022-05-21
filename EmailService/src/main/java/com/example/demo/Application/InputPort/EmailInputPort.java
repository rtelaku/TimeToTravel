package com.example.demo.Application.InputPort;

public interface EmailInputPort {
    void sendMessage(String to, String subject, String text);
}
