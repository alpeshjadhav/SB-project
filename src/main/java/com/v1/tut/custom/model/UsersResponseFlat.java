package com.v1.tut.custom.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UsersResponseFlat {
    private List<UserApiModel> users;
}
