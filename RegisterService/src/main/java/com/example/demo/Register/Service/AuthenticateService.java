package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.RequestHelper;
import com.example.demo.Register.Helper.ResponseHelper;
import com.example.demo.Register.Helper.UserHelper;
import com.example.demo.Register.JWT.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService implements IAuthenticateService {

    @Autowired
    private Token token;

    @Autowired
    private IUserService iUserService;

    @Override
    public boolean checkIfUserExist(String username, String password) {
        return this.iUserService.checkIfUserIsValid(username,password);
    }

    @Override
    public String generateToken(RequestHelper requestHelper) {
        UserHelper userHelper = new UserHelper(requestHelper.getUsername(),requestHelper.getPassword());
        return this.token.generateToken(userHelper);
    }

    @Override
    public ResponseEntity<ResponseHelper> signIn(RequestHelper requestHelper) {
        if(checkIfUserExist(requestHelper.getUsername(),requestHelper.getPassword())){
             ResponseHelper responseHelper = new ResponseHelper (requestHelper.getUsername(),generateToken(requestHelper));

             return  ResponseEntity.ok(responseHelper);

        }else{
            ResponseHelper responseHelper = new ResponseHelper("not found","not found");
            return  ResponseEntity.ok(responseHelper);
        }
    }

    @Override
    public ResponseHelper getResponseHelperFromValidToken(String token) {
        return this.token.getResponseHelperFromValidToken(token);
    }
}
