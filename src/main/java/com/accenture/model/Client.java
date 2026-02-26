package com.accenture.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
public class Client {

    @Id
    private int id;

    private String firstName;
    private String lastName;
    private String address;
    private String mail;
    private String password;
    private String birthday;
    private String registerDate;
    private List<String> drivingLicenses;
    private boolean deactivate;
}
