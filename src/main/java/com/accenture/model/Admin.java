package com.accenture.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Admin extends ConnectedUser{

    private String function;

    public Admin(String firstName, String lastName, String function, String mail, String password, Role role) {
        super(firstName,lastName,mail,password,role);
        this.function = function;
    }
}
