package com.greenfox.exam.badiusosicgreentribes.API.controllers;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.service.KingdomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KingdomAPI {
    private KingdomService kingdomService;

    public KingdomAPI(KingdomService kingdomService) {
        this.kingdomService = kingdomService;
    }

    @GetMapping("/kingdoms")
    public ResponseEntity<?> getKingdoms(){
        List<Kingdom> kingdoms = kingdomService.getKingdoms();
        return ResponseEntity.ok().body(kingdoms);
    }
    @GetMapping("/kingdoms/{id}")
    public ResponseEntity<?> getKingdom(@PathVariable Long id){
        return ResponseEntity.ok().body(kingdomService.findById(id));
    }
    @PutMapping("/kingdoms/{id}")
    public ResponseEntity<?> updateKingdom(@PathVariable Long id, @RequestBody Kingdom kingdom){
        if(!kingdomService.existsById(id)) throw new IllegalArgumentException("Kingdom does not exist");
        kingdomService.updateById(id, kingdom);
        return ResponseEntity.ok().body(kingdomService.findById(id));

    }
}
