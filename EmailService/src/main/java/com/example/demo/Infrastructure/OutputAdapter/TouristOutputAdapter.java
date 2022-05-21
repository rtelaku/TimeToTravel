package com.example.demo.Infrastructure.OutputAdapter;

import com.example.demo.Core.Helper.TouristHelper;
import com.example.demo.Core.OutputPort.TouristOutputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TouristOutputAdapter implements TouristOutputPort {
    @Override
    public TouristHelper getTouristByUsername(String username) {
        RestTemplate restTemplate =new RestTemplate();
        String registerServiceURL = "http://localhost:8080/api/register/tourist/get/tourist/" + username;
        ResponseEntity<TouristHelper> responseEntity = restTemplate.getForEntity(registerServiceURL, TouristHelper.class);

        TouristHelper touristHelper= responseEntity.getBody();

        return touristHelper;
    }
}