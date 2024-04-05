package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapArea {
    private Integer width;
    private Integer height;
    private Integer top;
    private Integer left;
}

