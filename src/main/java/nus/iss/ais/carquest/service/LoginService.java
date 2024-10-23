package nus.iss.ais.carquest.service;


import javax.crypto.SecretKey;

public interface LoginService {
    String login(String username, String password);
    Integer getUserIdFromToken(String token);
}
