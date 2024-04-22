package com.greenfox.exam.badiusosicgreentribes.domain.request;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.BuildingType;
import lombok.Data;

@Data
public class AddBuildingRequest {
    private BuildingType buildingType;
}
