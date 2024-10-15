package com.v1.tut.custom.model;

import lombok.Data;

@Data
public class UserApiModel {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String username;
    private String ip;
    private Address address;
    private Company company;
    private String role;
}
