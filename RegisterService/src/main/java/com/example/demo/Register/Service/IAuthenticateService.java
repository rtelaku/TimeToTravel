package com.example.demo.Register.Service;


import com.example.demo.Register.Helper.RequestHelper;
import com.example.demo.Register.Helper.ResponseHelper;
import org.springframework.http.ResponseEntity;

public interface IAuthenticateService {

    boolean checkIfUserExist(String username,String password);

    String generateToken(RequestHelper requestHelper);

    ResponseEntity<ResponseHelper> signIn(RequestHelper requestHelper);

    ResponseHelper getResponseHelperFromValidToken(String token);

}
