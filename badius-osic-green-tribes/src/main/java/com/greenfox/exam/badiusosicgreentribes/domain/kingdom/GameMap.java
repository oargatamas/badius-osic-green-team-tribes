package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "Maps")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameMap {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer kingdomLimit;

    private Integer kingdomCount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "width", column = @Column(name = "global_width")),
            @AttributeOverride(name = "height", column = @Column(name = "global_height")),
            @AttributeOverride(name = "top", column = @Column(name = "global_top")),
            @AttributeOverride(name = "left", column = @Column(name = "global_left")),
    })
    private MapArea global;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "width", column = @Column(name = "center_width")),
            @AttributeOverride(name = "height", column = @Column(name = "center_height")),
            @AttributeOverride(name = "top", column = @Column(name = "center_top")),
            @AttributeOverride(name = "left", column = @Column(name = "center_left")),
    })
    private MapArea center;

    @ManyToMany(mappedBy = "maps")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<User> users;

}
