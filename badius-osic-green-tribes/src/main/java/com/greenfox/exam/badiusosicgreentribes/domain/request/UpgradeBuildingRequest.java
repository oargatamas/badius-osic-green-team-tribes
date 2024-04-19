package com.greenfox.exam.badiusosicgreentribes.domain.request;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.BuildingType;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UpgradeBuildingRequest {
    private Long id;
    private BuildingType type;
    private String level;
    private Integer hp;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
}
