package com.example.demo;

import com.example.demo.Core.Domain.ReservationDomain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Timer;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }


  //  @Bean
  //  @LoadBalanced
  //  public RestTemplate restTemplate(){
  //      return new RestTemplate();
 //   }
}
