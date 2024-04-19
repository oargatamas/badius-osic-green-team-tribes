package com.greenfox.exam.badiusosicgreentribes.API.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaderboardAPI {


    @GetMapping("/kingdoms/{id}/troops")
    public ResponseEntity<?> getLeaderboardTroops(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kingdoms/{id}/troops")
    public ResponseEntity<?> getLeaderboardBuildings(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kingdoms/{id}/troops")
    public ResponseEntity<?> getLeaderboardKingdoms(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }
}
