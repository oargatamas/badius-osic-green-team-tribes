package com.greenfox.exam.badiusosicgreentribes.domain.common;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cost {

    @Column (name = "cost_duration")
    private Integer duration;

    @Column (name = "cost_food")
    private Integer food;

    @Column (name = "cost_gold")
    private Integer gold;


}
