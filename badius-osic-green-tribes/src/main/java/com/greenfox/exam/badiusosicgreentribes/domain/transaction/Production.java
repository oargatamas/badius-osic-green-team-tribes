package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Productions")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Production extends Transaction{

    private Integer quantity;

    @Enumerated(value = EnumType.STRING)
    private ProductionUnitType type;


    @JoinColumn(name = "target_kingdom")
    @ManyToOne
    private Kingdom targetKingdom;

}
