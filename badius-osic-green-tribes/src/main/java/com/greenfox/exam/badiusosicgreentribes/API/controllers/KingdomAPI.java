package com.greenfox.exam.badiusosicgreentribes.API.controllers;

import com.greenfox.exam.badiusosicgreentribes.domain.request.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KingdomAPI {

    @GetMapping("/kingdoms")
    public ResponseEntity<?> getKingdoms() {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kingdoms/{id}")
    public ResponseEntity<?> getKingdom(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @PutMapping("/kingdoms/{id}")
    public ResponseEntity<?> updateKingdom(@PathVariable Long id, @RequestBody UpdateKingdomRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kingdoms/{id}/resources")
    public ResponseEntity<?> getResources(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kingdoms/{id}/buildings")
    public ResponseEntity<?> getBuildings(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @PostMapping("/kingdoms/{id}/buildings")
    public ResponseEntity<?> addBuilding(@PathVariable Long id, @RequestBody AddBuildingRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @PutMapping("/kingdoms/{id1}/buildings/{id2}")
    public ResponseEntity<?> upgradeBuilding(@PathVariable Long id1, @PathVariable Long id2, @RequestBody UpgradeBuildingRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kingdoms/{id}/troops")
    public ResponseEntity<?> getTroops(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @PostMapping("/kingdoms/{id}/troops")
    public ResponseEntity<?> addTroops(@PathVariable Long id, @RequestBody AddTroopsRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @PutMapping("/kingdoms/{id}/troops")
    public ResponseEntity<?> upgradeTroops(@PathVariable Long id, @RequestBody UpgradeTroopsRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }
}

