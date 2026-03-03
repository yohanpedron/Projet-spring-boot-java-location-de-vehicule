package com.accenture.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Client extends ConnectedUser {

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private LocalDate birthday;
    private LocalDate registerDate;

    private List<String> drivingLicenses;

    private boolean deactivate;

    public Client(String firstName, String lastName, Address address, String mail, String password, Role role, LocalDate birthday, LocalDate registerDate, List<String> drivingLicenses, boolean deactivate) {
        super(firstName,lastName,mail,password,role);
        this.address = address;
        this.birthday = birthday;
        this.registerDate = registerDate;
        this.drivingLicenses = drivingLicenses;
        this.deactivate = deactivate;
    }

    public Client(String firstName, String lastName, Address address, String mail, String password, Role role, LocalDate birthday, LocalDate registerDate, List<String> drivingLicenses) {
        super(firstName,lastName,mail,password,role);
        this.address = address;
        this.birthday = birthday;
        this.registerDate = registerDate;
        this.drivingLicenses = drivingLicenses;
    }

    public Client(String firstName, String lastName, Address address, String mail, String password, Role role, LocalDate birthday, List<String> drivingLicenses) {
        super(firstName,lastName,mail,password,role);
        this.address = address;
        this.birthday = birthday;
        this.drivingLicenses = drivingLicenses;
    }
}
