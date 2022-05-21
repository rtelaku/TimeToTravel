package com.example.demo.Infrastructure.OutputAdapter;

import com.example.demo.Core.Helper.BusinessHelper;
import com.example.demo.Core.OutputPort.BusinessOutputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BusinessOutputAdapter implements BusinessOutputPort {

    @Override
    public BusinessHelper getBusinessByUsername(String username) {
        RestTemplate restTemplate=new RestTemplate();
        String registerServiceURL = "http://localhost:8080/api/register/business/get/business/byUsername/"+username;
        ResponseEntity<BusinessHelper> responseEntity = restTemplate.getForEntity(registerServiceURL,BusinessHelper.class);

        BusinessHelper businessHelper= responseEntity.getBody();

        return businessHelper;
    }
}
