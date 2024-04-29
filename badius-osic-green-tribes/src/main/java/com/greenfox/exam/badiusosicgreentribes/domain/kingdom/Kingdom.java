package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Unit;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Kingdoms")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kingdom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "coordinate_x")
    private Integer coordinateX;

    @Column(name = "coordinate_y")
    private Integer coordinateY;

    @ManyToOne
    private User owner;

    @ManyToOne
    private GameMap map;

    @Embedded
    private Storage storage;

    public void addBuilding(BuildingType buildingType, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Building newBuilding = new Building();
            newBuilding.setType(buildingType);
            storage.getBuildings().add(newBuilding);
        }
    }

    public void addTroop(UnitType unitType, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Troop newTroop = new Troop();
            Unit newUnit = new Unit();
            newTroop.setUnit(newUnit);
            newTroop.getUnit().setType(unitType);
            storage.getDefenderArmy().getTroops().add(newTroop);
        }
    }
}
