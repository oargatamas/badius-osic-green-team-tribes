package com.greenfox.exam.badiusosicgreentribes.domain.request;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import lombok.Data;

@Data
public class UpgradeTroopsRequest {
    private UnitType type;
}
