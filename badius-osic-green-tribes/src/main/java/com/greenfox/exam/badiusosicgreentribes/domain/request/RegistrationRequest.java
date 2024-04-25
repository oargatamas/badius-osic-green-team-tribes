package com.greenfox.exam.badiusosicgreentribes.domain.request;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String username;
    private String password;
    private String kingdomName;
}
