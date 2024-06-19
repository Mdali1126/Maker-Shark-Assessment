package com.makershark.Assessment.jwt;


import com.makershark.Assessment.dao.request.LoginRequest;
import com.makershark.Assessment.dao.request.RegisterRequest;
import com.makershark.Assessment.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse register(RegisterRequest request);
    JwtAuthenticationResponse login(LoginRequest request);
}
