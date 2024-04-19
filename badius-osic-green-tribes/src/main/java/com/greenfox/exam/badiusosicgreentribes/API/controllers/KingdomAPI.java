package com.greenfox.exam.badiusosicgreentribes.API.controllers;

import com.greenfox.exam.badiusosicgreentribes.domain.request.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kingdoms")
public class KingdomAPI {

    @GetMapping("")
    public ResponseEntity<?> getKingdoms() {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKingdom(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateKingdom(@PathVariable Long id, @RequestBody UpdateKingdomRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/resources")
    public ResponseEntity<?> getResources(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/buildings")
    public ResponseEntity<?> getBuildings(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/buildings")
    public ResponseEntity<?> addBuilding(@PathVariable Long id, @RequestBody AddBuildingRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id1}/buildings/{id2}")
    public ResponseEntity<?> upgradeBuilding(@PathVariable Long id1, @PathVariable Long id2, @RequestBody UpgradeBuildingRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/troops")
    public ResponseEntity<?> getTroops(@PathVariable Long id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/troops")
    public ResponseEntity<?> addTroops(@PathVariable Long id, @RequestBody AddTroopsRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/troops")
    public ResponseEntity<?> upgradeTroops(@PathVariable Long id, @RequestBody UpgradeTroopsRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }
}

