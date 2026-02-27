package com.accenture.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    private String mail;
    private String password;
    private String birthday;
    private String registerDate;

    private List<String> drivingLicenses;

    private boolean deactivate;

    public Client(String firstName, String lastName, Address address, String mail, String password, String birthday, String registerDate, List<String> drivingLicenses, boolean deactivate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mail = mail;
        this.password = password;
        this.birthday = birthday;
        this.registerDate = registerDate;
        this.drivingLicenses = drivingLicenses;
        this.deactivate = deactivate;
    }

    public Client(String firstName, String lastName, Address address, String mail, String password, String birthday, String registerDate, List<String> drivingLicenses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mail = mail;
        this.password = password;
        this.birthday = birthday;
        this.registerDate = registerDate;
        this.drivingLicenses = drivingLicenses;
    }
}
