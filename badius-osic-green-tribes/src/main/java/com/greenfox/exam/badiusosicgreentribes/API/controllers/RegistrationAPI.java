package com.greenfox.exam.badiusosicgreentribes.API.controllers;

import com.greenfox.exam.badiusosicgreentribes.domain.request.AuthorizationRequest;
import com.greenfox.exam.badiusosicgreentribes.domain.request.ValidationRequest;
import com.greenfox.exam.badiusosicgreentribes.domain.request.KingdomRegistrationRequest;
import com.greenfox.exam.badiusosicgreentribes.domain.request.RegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationAPI {

    @PostMapping("/registration")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        // TODO
        return ResponseEntity.ok().build();
    }

    @PutMapping("/registration")
    public ResponseEntity<?> placeKingdom(@RequestBody KingdomRegistrationRequest request) {
        // TODO
        return ResponseEntity.ok().build();

    }@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ValidationRequest request) {
        // TODO
        return ResponseEntity.ok().build();
    }@PostMapping("/registration")
    public ResponseEntity<?> register(@RequestBody AuthorizationRequest request) {
        // TODO
        return ResponseEntity.ok().build();
    }
}
