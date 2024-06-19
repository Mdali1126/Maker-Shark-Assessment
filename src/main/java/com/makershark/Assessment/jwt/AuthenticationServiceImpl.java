package com.makershark.Assessment.jwt;

import com.makershark.Assessment.dao.request.LoginRequest;
import com.makershark.Assessment.dao.request.RegisterRequest;
import com.makershark.Assessment.dao.response.JwtAuthenticationResponse;
import com.makershark.Assessment.model.User;
import com.makershark.Assessment.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public JwtAuthenticationResponse register(RegisterRequest request) {
        User user = User.builder().username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword())).build();
        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();


    }
}
