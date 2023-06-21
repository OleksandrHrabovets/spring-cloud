package com.example.authservice.services;

import com.example.authservice.entities.AuthRequest;
import com.example.authservice.entities.AuthResponse;
import com.example.authservice.entities.value_objects.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final RestTemplate restTemplate;
  private final JwtUtil jwt;

  public AuthResponse register(AuthRequest authRequest) {
    //do validation if user already exists
    authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));

    UserVO userVO = restTemplate.postForObject("http://user-service/users", authRequest,
        UserVO.class);
    Assert.notNull(userVO, "Failed to register user. Please try again later");

    String accessToken = jwt.generate(userVO, "ACCESS");
    String refreshToken = jwt.generate(userVO, "REFRESH");

    return new AuthResponse(accessToken, refreshToken);

  }
}
