package com.example.demo.Register.Controller;

import com.example.demo.Register.Helper.RequestHelper;
import com.example.demo.Register.Helper.ResponseHelper;
import com.example.demo.Register.Service.IAuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/register/authenticate")
public class AuthenticateController {

    @Autowired
    private IAuthenticateService iAuthenticateService;

    public AuthenticateController(IAuthenticateService authenticateService) {
        this.iAuthenticateService = authenticateService;
    }

    //user gets token from responseHelper
    @PostMapping("/signIn")
    public ResponseEntity<ResponseHelper> signIn(@RequestBody RequestHelper requestHelper){
        return this.iAuthenticateService.signIn(requestHelper);
    }

    @PostMapping("/validate/{token}")
    public ResponseEntity<ResponseHelper> validateToken(@PathVariable("token") String token){
        return ResponseEntity.ok(this.iAuthenticateService.getResponseHelperFromValidToken(token));
    }

}

