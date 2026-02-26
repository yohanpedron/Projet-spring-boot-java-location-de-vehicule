package com.accenture.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Client(String firstName, String lastName, String address, String mail, String birthday, String password, String registerDate, List<String> drivingLicenses, boolean deactivate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mail = mail;
        this.birthday = birthday;
        this.password = password;
        this.registerDate = registerDate;
        this.drivingLicenses = drivingLicenses;
        this.deactivate = deactivate;
    }
}
