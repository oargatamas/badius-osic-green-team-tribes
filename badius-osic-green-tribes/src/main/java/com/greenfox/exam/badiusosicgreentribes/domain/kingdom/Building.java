package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.common.Cost;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "Buildings")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer level;

    private Integer hp;

    @Enumerated(value = EnumType.STRING)
    private BuildingType type;

    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Transaction> transactions;

    @Embedded
    private Cost cost;

    @ManyToOne
    private Kingdom kingdom;

}
