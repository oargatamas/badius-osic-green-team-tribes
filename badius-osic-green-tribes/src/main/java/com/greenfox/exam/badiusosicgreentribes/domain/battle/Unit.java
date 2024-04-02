package com.greenfox.exam.badiusosicgreentribes.domain.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.common.Cost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "icon_url")
    private String iconUrl;

    @Embedded
    private UnitStats stats;

    @Column(name = "unit_type")
    @Enumerated(value = EnumType.STRING)
    private UnitType type;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "duration", column = @Column(name = "creation_cost_duration")),
            @AttributeOverride(name = "food", column = @Column(name = "creation_cost_food")),
            @AttributeOverride(name = "gold", column = @Column(name = "creation_cost_gold")),
    })
    private Cost creationCost;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "duration", column = @Column(name = "upgrade_cost_duration")),
            @AttributeOverride(name = "food", column = @Column(name = "upgrade_cost_food")),
            @AttributeOverride(name = "gold", column = @Column(name = "upgrade_cost_gold")),
    })
    private Cost upgradeCost;

}
