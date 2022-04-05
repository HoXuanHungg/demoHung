package com.example.demohung.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserDetail implements Serializable {

    private String firstname;
    private String lastname;
}
