package com.greenfox.exam.badiusosicgreentribes.API.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leaderboards")
public class LeaderboardAPI {


    @GetMapping("/{id}/troops")
    public ResponseEntity<?> getLeaderboardTroops(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/buildings")
    public ResponseEntity<?> getLeaderboardBuildings(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/kingdoms")
    public ResponseEntity<?> getLeaderboardKingdoms(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }
}
