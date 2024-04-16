package com.greenfox.exam.badiusosicgreentribes.model.battle;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TroopInfo {
    private String unit;
    private Integer quantity;
    private Integer health;

}
