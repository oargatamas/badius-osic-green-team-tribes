package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Movements")
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movement extends Transaction {

    @ManyToOne
    private Kingdom origin;
    @ManyToOne
    private Kingdom destination;
    @OneToOne
    private Army army;
    @Column(columnDefinition = "boolean default true")
    private Boolean refundable;
}
