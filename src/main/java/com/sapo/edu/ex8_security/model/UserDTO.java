package com.sapo.edu.ex8_security.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
public class UserDTO {


    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
