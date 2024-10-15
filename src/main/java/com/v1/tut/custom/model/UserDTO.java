package com.v1.tut.custom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String username;
    private String ip;

    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;

    private String name;
    private String department;
    private String title;

    private String role;
}
