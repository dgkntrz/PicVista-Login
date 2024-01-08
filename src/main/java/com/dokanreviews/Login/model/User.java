package com.dokanreviews.Login.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
public class User {

    @Id
    private String userId;

    @Indexed(unique = true)
    private String userName;
    private String password;
    private String signUpDate;


    public User(String userName, String password, String signUpDate){
        super();
        this.userName = userName;
        this.password = password;
        this.signUpDate = signUpDate;
    }


}
