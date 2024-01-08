package com.picvista.Login.controller;

import com.picvista.Login.exceptions.PasswordNotValidException;
import com.picvista.Login.exceptions.UserNotValidException;
import com.picvista.Login.model.UserDTO;
import com.picvista.Login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) throws PasswordNotValidException, UserNotValidException {
        String userName = loginService.logIn(userDTO).getUserName();
        return ResponseEntity.ok(userName);
    }

}