package nus.iss.ais.carquest.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import nus.iss.ais.carquest.mapper.UsersMapper;
import nus.iss.ais.carquest.model.SearchHistory;
import nus.iss.ais.carquest.model.Users;
import nus.iss.ais.carquest.model.UsersExample;
import nus.iss.ais.carquest.service.LoginService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UsersMapper usersMapper;
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    @Override
    public String login(String username, String password) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<Users> usersList = usersMapper.selectByExample(example);

        if (usersList != null && !usersList.isEmpty()) {
            String userId = String.valueOf(usersList.get(0).getUserId());
            // 生成 JWT token
            String jwtToken = Jwts.builder()
                    .setSubject(userId)
                    .signWith(secretKey, SignatureAlgorithm.HS256)
                    .compact();
            return jwtToken;
        } else {
            return null;
        }
    }

    @Override
    public Integer getUserIdFromToken(String token) {
        try {
            String userIdStr = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();

            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                return null;
            }
            return Integer.parseInt(userIdStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
