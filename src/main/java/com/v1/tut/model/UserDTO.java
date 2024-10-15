package com.v1.tut.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String street;
    private String city;
}
