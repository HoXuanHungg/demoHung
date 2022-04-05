package com.example.demohung.Entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "hung")
@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;
    //id này sẽ tự tăng
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstname;
    private String lastname;
    private String address;


}
