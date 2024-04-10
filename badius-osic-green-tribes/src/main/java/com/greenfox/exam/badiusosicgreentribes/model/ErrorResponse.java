package com.greenfox.exam.badiusosicgreentribes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponse {
    HttpStatus httpStatus;
    String message;
}
