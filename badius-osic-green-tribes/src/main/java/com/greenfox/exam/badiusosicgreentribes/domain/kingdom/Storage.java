package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {

    private Integer food;

    private Integer gold;

    @PrimaryKeyJoinColumn(name = "defender_army")
    @OneToOne
    private Army defenderArmy;

    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Army> armies;

    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Building> buildings;

}
