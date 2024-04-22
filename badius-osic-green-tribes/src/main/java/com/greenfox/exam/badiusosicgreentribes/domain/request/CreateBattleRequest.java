package com.greenfox.exam.badiusosicgreentribes.domain.request;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Unit;
import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import lombok.Data;

import java.util.List;

@Data
public class CreateBattleRequest {
    private Target target;
    private List<Troop> troops;

    @Data
    public class Target {
        private Long kingdomId;
        private String kingdomName;
        private User player;
        private Location location;
    }

    @Data
    public class Location {
        private Integer coordinateX;
        private Integer coordinateY;
    }

    @Data
    public class Troop {
        private Unit unit;
        private Integer quantity;
    }
}
