package com.blanke.hanu.rest;


import com.blanke.hanu.rest.dto.request.LoginRequest;
import com.blanke.hanu.rest.dto.response.JwtResponse;
import com.blanke.hanu.security.JwtAuthenticationToken;
import com.blanke.hanu.security.JwtService;
import com.blanke.hanu.util.BodyResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationProvider authenticationProvider;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationProvider
                .authenticate(new JwtAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        //TODO: create jwt and response
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // create JWT
        String jwtToken = jwtService.generateToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse(jwtToken);

        return ResponseEntity.ok(jwtResponse);
    }

    //TODO: aplly register
    @GetMapping("/register")
    public ResponseEntity<String> register() {

        return ResponseEntity.ok("create account successfully! okkkkkk mannnnn");
    }
}