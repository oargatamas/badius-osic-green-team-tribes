package com.greenfox.exam.badiusosicgreentribes.domain.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name="Armies")
public class Army {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private ArmyState state;

    private Integer size;

    @Embedded
    private UnitStats stats;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "army")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Troop> troops;

    @ManyToOne
    private Kingdom kingdom;



}
