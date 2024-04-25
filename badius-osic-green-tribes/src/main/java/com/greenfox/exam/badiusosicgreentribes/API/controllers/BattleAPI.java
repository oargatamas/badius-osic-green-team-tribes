package com.greenfox.exam.badiusosicgreentribes.API.controllers;

import com.greenfox.exam.badiusosicgreentribes.domain.request.CreateBattleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kingdoms/{id}/battles")
public class BattleAPI {

    @PostMapping("")
    public ResponseEntity<?> createBattle(@PathVariable Long id, @RequestBody CreateBattleRequest request) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id2}")
    public ResponseEntity<?> getBattleResult(@PathVariable Long id, @PathVariable Long id2) {
        //TODO
        return ResponseEntity.ok().build();
    }

}
