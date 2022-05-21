package com.example.demo.Register.JWT;

import com.example.demo.Register.Exception.AppException;
import com.example.demo.Register.Helper.ResponseHelper;
import com.example.demo.Register.Helper.UserHelper;
import com.example.demo.Register.Models.Tourist;
import com.example.demo.Register.Service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Component
public class Token {

    private static final long serialVersionUID = 234234523523L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    //@Value("${jwt.secret}")
    private String secretKey="secretkey123secretkey123secretkey123secretkey123";

    @Autowired
    private UserService userService;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }


    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //for retrieving any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserHelper userHelper) {
        Claims claims = Jwts.claims().setSubject(userHelper.getUsername());

        return doGenerateToken(claims, userHelper.getUsername());
    }

    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    private String doGenerateToken(Claims claims, String subject) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000);
        return Jwts.builder().setClaims(claims).setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }

    //validate token
    public Boolean validateToken(String token) {
        final String username = getUsernameFromToken(token);
        Tourist user= (Tourist) this.userService.getUserByUsername(username).getData();
       // UserHelper user = (UserHelper) object;

        if(username.equals(user.getUsername()) && !isTokenExpired(token)) {
            return true;
        }else{
            return false;
        }

    }

    public ResponseHelper getResponseHelperFromValidToken(String token){
        if(validateToken(token)){
            String username = getUsernameFromToken(token);
            return new ResponseHelper(username,token);
        }else{
            throw new AppException("Invalid Token", HttpStatus.BAD_REQUEST);
        }
    }

}
