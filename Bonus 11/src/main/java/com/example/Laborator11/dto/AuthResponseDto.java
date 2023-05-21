package com.example.Laborator11.dto;

public class AuthResponseDto {
    private String accessToken;
    private String tokenType="Bearer ";

    public AuthResponseDto(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public AuthResponseDto() {
    }

    public AuthResponseDto(String accessToken, String tokenType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

}