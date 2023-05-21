package com.example.Laborator11.controller;

import com.example.Laborator11.dto.AuthResponseDto;
import com.example.Laborator11.dto.LoginRequestBody;
import com.example.Laborator11.dto.RegisterRequestBody;
import com.example.Laborator11.model.Player;
import com.example.Laborator11.repository.PlayerRepository;
import com.example.Laborator11.security.JWTGenerator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;

    private final  PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;


    public AuthController(AuthenticationManager authenticationManager, PlayerRepository playerRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestBody loginRequestBody, HttpServletRequest request ) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestBody.getName(),
                loginRequestBody.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Player credentials = playerRepository.getByName(loginRequestBody.getName());

        String token = jwtGenerator.generateToken(loginRequestBody.getName());
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestBody registerRequestBody) {
        Player player = new Player();
        try {
            if (playerRepository.existsByName(registerRequestBody.getName())) {
                return new ResponseEntity<>("Name is already in use!", HttpStatus.BAD_REQUEST);
            }
                    player.setName(registerRequestBody.getName());
                    player.setPassword(passwordEncoder.encode(registerRequestBody.getPassword()));
                    playerRepository.save(player);
            } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error when saving user!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
