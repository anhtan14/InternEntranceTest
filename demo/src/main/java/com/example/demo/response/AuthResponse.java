package com.example.demo.response;

import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;
    private String message;
}
