package com.dokanreviews.Login.controller;

import com.dokanreviews.Login.exceptions.GenericException;
import com.dokanreviews.Login.exceptions.UsernameAlreadyExistsException;
import com.dokanreviews.Login.model.UserDTO;
import com.dokanreviews.Login.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.dokanreviews.Login.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody UserDTO userDTO) throws GenericException {
        String userId = signUpService.createAccount(userDTO);
        return ResponseEntity.ok(userId);
    }

}
