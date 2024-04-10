package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.common.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Kingdoms")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kingdom {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "coordinate_x")
    private Integer coordinateX;

    @Column(name = "coordinate_y")
    private Integer coordinateY;

    @ManyToOne
    private Player owner;

    @ManyToOne
    private GameMap map;

    @Embedded
    private Storage storage;
}
