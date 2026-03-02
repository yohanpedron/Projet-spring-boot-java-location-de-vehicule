package com.accenture.model;

import com.accenture.service.dto.AddressDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private String mail;
    private String password;

    private LocalDate birthday;
    private LocalDate registerDate;

    private List<String> drivingLicenses;

    private boolean deactivate;

    public Client(String firstName, String lastName, Address address, String mail, String password, LocalDate birthday, LocalDate registerDate, List<String> drivingLicenses, boolean deactivate) {
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

    public Client(String firstName, String lastName, Address address, String mail, String password, LocalDate birthday, LocalDate registerDate, List<String> drivingLicenses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mail = mail;
        this.password = password;
        this.birthday = birthday;
        this.registerDate = registerDate;
        this.drivingLicenses = drivingLicenses;
    }

    public Client(String firstName, String lastName, Address address, String mail, String password, LocalDate birthday, List<String> drivingLicenses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mail = mail;
        this.password = password;
        this.birthday = birthday;
        this.drivingLicenses = drivingLicenses;
    }
}
