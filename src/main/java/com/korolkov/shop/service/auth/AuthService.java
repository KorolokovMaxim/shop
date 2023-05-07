package com.korolkov.shop.service.auth;

import com.korolkov.shop.config.JwtService;
import com.korolkov.shop.entity.user.User;
import com.korolkov.shop.enums.user.Role;
import com.korolkov.shop.repository.user.UserRepository;
import com.korolkov.shop.request.AuthenticationRequest;
import com.korolkov.shop.request.RegisterRequest;
import com.korolkov.shop.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        String createdBy = "AuthSystemUser";
        User user = new User();
        user.setCreatedBy(createdBy);
        user.setCreatedAt(LocalDateTime.now());
        user.setFirstname(request.getFirstname());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setRole(Role.USER);
        repository.saveAndFlush(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse auth(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findUserByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
