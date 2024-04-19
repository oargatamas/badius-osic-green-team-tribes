package com.greenfox.exam.badiusosicgreentribes.domain.request;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import lombok.Data;

@Data
public class AddTroopsRequest {
    private UnitType type;
    private Integer quantity;
}
