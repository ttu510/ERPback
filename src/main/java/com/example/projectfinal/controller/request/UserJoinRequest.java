package com.example.projectfinal.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinRequest {
    private String username;
    private String password;
    private String name;
}
