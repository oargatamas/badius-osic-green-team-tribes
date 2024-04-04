package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Movements")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movement extends Transaction{

    @ManyToOne
    private Kingdom origin;
    @ManyToOne
    private Kingdom destination;
    @OneToOne
    private Army army;
}
