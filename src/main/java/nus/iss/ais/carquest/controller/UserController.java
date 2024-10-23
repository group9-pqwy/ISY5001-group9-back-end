package nus.iss.ais.carquest.controller;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import nus.iss.ais.carquest.entity.Profile;
import nus.iss.ais.carquest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Profile profile) {

        String token = loginService.login(profile.getUsername(), profile.getPassword());
        if(token!=null) {
            Map<String,String> response = new HashMap<>();
            response.put("token",token);
            return ResponseEntity.ok(response);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
