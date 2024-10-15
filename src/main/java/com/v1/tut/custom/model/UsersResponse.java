package com.v1.tut.custom.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UsersResponse {
    private List<UserApiModel> users;
}
