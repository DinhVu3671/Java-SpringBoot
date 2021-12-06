package com.sapo.edu.ex8_security.payload.response;

import lombok.Data;

import java.io.Serializable;
@Data
public class JwtResponse implements Serializable {
    private String token;
    private String type = "Bearer";

    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }
}
