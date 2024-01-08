package com.picvista.Login.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String userName;
    private String password;
    private String email;

    public UserDTO(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

}
