package com.greenfox.exam.badiusosicgreentribes.service;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.KingdomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KingdomService {
    private KingdomRepository kingdomRepository;

    public KingdomService(KingdomRepository kingdomRepository) {
        this.kingdomRepository = kingdomRepository;
    }
    public List<Kingdom> getKingdoms(){
        return kingdomRepository.findAll();
    }

    public Kingdom findById(Long id) {
        return kingdomRepository.findById(id).orElseThrow();
    }
    public void save(Kingdom kingdom){
        kingdomRepository.save(kingdom);
    }
    public void updateById(Long id, Kingdom kingdom){
        if(!kingdomRepository.existsById(id)) throw new IllegalArgumentException("Kingdom does not exist");
        kingdom.setId(id);
        kingdomRepository.save(kingdom);
    }
    public Boolean existsById(Long id){
        return kingdomRepository.existsById(id);
    }
}
