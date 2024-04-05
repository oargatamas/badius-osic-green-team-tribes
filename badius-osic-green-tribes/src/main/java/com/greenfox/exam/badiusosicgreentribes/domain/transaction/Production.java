package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Productions")
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Production extends Transaction{

    private Integer quantity;

    @Enumerated(value = EnumType.STRING)
    private ProductionUnitType productionType;


    @JoinColumn(name = "target_kingdom")
    @ManyToOne
    private Kingdom targetKingdom;

}
